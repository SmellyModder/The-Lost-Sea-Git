package com.SmellyModder.TheLostSea.client.render.shader;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class ToneMapper extends PostProcessingEffect<ToneMapper> {
	private float gamma = 1.0F;
	private float exposure = 1.0F;

	private int gammaUniformID = -1;
	private int exposureUniformID = -1;

	public ToneMapper setGamma(float gamma) {
		this.gamma = gamma;
		return this;
	}

	public ToneMapper setExposure(float exposure) {
		this.exposure = exposure;
		return this;
	}

	@Override
	protected ResourceLocation[] getShaders() {
		return new ResourceLocation[] {new ResourceLocation("thelostsea:shaders/postprocessing/tonemapper/tonemapper.vsh"), new ResourceLocation("thelostsea:shaders/postprocessing/tonemapper/tonemapper.fsh")};
	}

	@Override
	protected boolean initEffect() {
		this.gammaUniformID = OpenGlHelper.glGetUniformLocation(this.getShaderProgram(), "u_gamma");
		this.exposureUniformID = OpenGlHelper.glGetUniformLocation(this.getShaderProgram(), "u_exposure");
		return true;
	}

	@Override
	protected void uploadUniforms(float partialTicks) {
		this.uploadFloat(this.gammaUniformID, this.gamma);
		this.uploadFloat(this.exposureUniformID, this.exposure);
	}

}
