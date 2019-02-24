package com.SmellyModder.TheLostSea.common.world.gen.chunk;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.world.biome.layer.GenLayerTropicalIsland;
import com.SmellyModder.TheLostSea.common.world.biome.layer.GenLayerTropicalShore;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class IslandTerrainHandler {

	private static final Logger LOGGER = LogManager.getLogger(IslandTerrainHandler.class);
	 
    @SubscribeEvent
    public static void onInitBiomeGens(WorldTypeEvent.InitBiomeGens event) {
        GenLayer root = event.getNewBiomeGens()[0];
        insertAfterLast(root, l -> l instanceof GenLayerBiome, p -> new GenLayerTropicalIsland(3000L, p));
        insertAfterLast(root, l -> l instanceof GenLayerShore, p -> new GenLayerTropicalShore(6000L, p));
    }
    
    public static void insertLayer(GenLayer root, Predicate<GenLayer> predicate, int index, Function<GenLayer, GenLayer> insert) {
        List<GenLayer> layerStack = buildLayerStack(root, predicate);
        GenLayer target = layerStack.get(index);
        insertBefore(target, insert);
    }
 
    public static void insertAfterLast(GenLayer root, Predicate<GenLayer> predicate, Function<GenLayer, GenLayer> insert) {
        GenLayer target = getLayerAfterLast(root, predicate, null);
        if (target != null) {
            insertBefore(target, insert);
        }
    }
 
    @Nullable
    private static GenLayer getLayerAfterLast(GenLayer root, Predicate<GenLayer> predicate, GenLayer next) {
        if (next != null && predicate.test(root)) {
            return next;
        }
 
        Collection<GenLayer> parents = reflectParents(root);
        for (GenLayer parent : parents) {
            GenLayer target = getLayerAfterLast(parent, predicate, root);
            if (target != null) {
                return target;
            }
        }
 
        return null;
    }
 
    private static List<GenLayer> buildLayerStack(GenLayer root, Predicate<GenLayer> predicate) {
        List<GenLayer> layers = new ArrayList<>();
 
        Stack<GenLayer> queue = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GenLayer layer = queue.pop();
            if (predicate.test(layer)) {
                layers.add(layer);
            }
            queue.addAll(reflectParents(layer));
        }
 
        return Lists.reverse(layers);
    }
 
    private static void insertBefore(GenLayer root, Function<GenLayer, GenLayer> insert) {
        Collection<Field> parentFields = reflectParentFields(root);
        if (parentFields.isEmpty()) {
            throw new IllegalArgumentException("cannot insert layer before layer without a parent");
        }
        for (Field parentField : parentFields) {
            try {
                GenLayer parent = (GenLayer) parentField.get(root);
                parentField.set(root, insert.apply(parent));
            } catch (Exception e) {
                LOGGER.error("failed to insert parent onto field {} on {}", parentField.getName(), root, e);
            }
        }
    }
 
    private static Collection<GenLayer> reflectParents(GenLayer layer) {
        Collection<Field> layerFields = reflectParentFields(layer);
 
        if (!layerFields.isEmpty()) {
            Collection<GenLayer> parents = new ArrayList<>();
            for (Field field : layerFields) {
                try {
                    GenLayer value = (GenLayer) field.get(layer);
                    if (value != null) {
                        parents.add(value);
                    }
                } catch (Exception e) {
                    LOGGER.error("failed to access field {} on {}", field.getName(), layer, e);
                }
            }
            return parents;
        }
 
        return Collections.emptyList();
    }
 
    private static Collection<Field> reflectParentFields(GenLayer layer) {
        Collection<Field> layerFields = getFields(layer.getClass()).stream()
                .filter(f -> GenLayer.class.isAssignableFrom(f.getType()))
                .collect(Collectors.toList());
        layerFields.forEach(f -> f.setAccessible(true));
        return layerFields;
    }
 
    private static Collection<Field> getFields(Class<?> clazz) {
        Collection<Field> fields = Lists.newArrayList(clazz.getDeclaredFields());
        if (clazz.getSuperclass() != null) {
            fields.addAll(getFields(clazz.getSuperclass()));
        }
        return fields;
    }
}
