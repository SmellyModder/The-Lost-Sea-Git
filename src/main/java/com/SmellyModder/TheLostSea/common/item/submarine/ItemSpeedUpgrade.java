package com.SmellyModder.TheLostSea.common.item.submarine;

import com.SmellyModder.TheLostSea.common.container.enums.EnumSubUpgrades;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

public class ItemSpeedUpgrade extends ItemSubUpgrades implements IHasModel
{
    public ItemSpeedUpgrade(String name)
    {
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(TheLostSea.TLS_VEHICLES);

        TLSItems.ITEMS.add(this);
    }

    @Override
    public EnumSubUpgrades getType()
    {
        return EnumSubUpgrades.SPEED;
    }

    @Override
    public boolean isContainer()
    {
        return false;
    }

    @Override
    public void registerModels()
    {
        TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
