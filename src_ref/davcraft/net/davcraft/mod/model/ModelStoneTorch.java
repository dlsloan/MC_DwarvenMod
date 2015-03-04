// Date: 8/13/2014 4:26:57 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.davcraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStoneTorch extends ModelBase
{
  //fields
    ModelRenderer Pillar;
    ModelRenderer leftArm;
    ModelRenderer rightArm;
    ModelRenderer frontArm;
    ModelRenderer backArm;
  
  public ModelStoneTorch()
  {
    textureWidth = 16;
    textureHeight = 16;
    
      Pillar = new ModelRenderer(this, 0, 0);
      Pillar.addBox(0F, 0F, 0F, 4, 12, 4);
      Pillar.setRotationPoint(-2F, 12F, -2F);
      Pillar.setTextureSize(16, 16);
      Pillar.mirror = true;
      setRotation(Pillar, 0F, 0F, 0F);
      
      
      leftArm = new ModelRenderer(this, 0, 0);
      leftArm.addBox(2F, 16F, -1F, 6, 6, 2);
      leftArm.setRotationPoint(0F, 0F, 0F);
      leftArm.setTextureSize(16, 16);
      leftArm.mirror = true;
      setRotation(leftArm, 0F, 0F, 0F);
      rightArm = new ModelRenderer(this, 0, 0);
      rightArm.addBox(0F, 0F, 0F, 6, 6, 2);
      rightArm.setRotationPoint(-2F, 16F, 1F);
      rightArm.setTextureSize(16, 16);
      rightArm.mirror = true;
      setRotation(rightArm, 0F, 3.141593F, 0F);
      frontArm = new ModelRenderer(this, 0, 0);
      frontArm.addBox(0F, 0F, 0F, 6, 6, 2);
      frontArm.setRotationPoint(-1F, 16F, -2F);
      frontArm.setTextureSize(16, 16);
      frontArm.mirror = true;
      setRotation(frontArm, 0F, 1.570796F, 0F);
      backArm = new ModelRenderer(this, 0, 0);
      backArm.addBox(0F, 0F, 0F, 6, 6, 2);
      backArm.setRotationPoint(1F, 16F, 2F);
      backArm.setTextureSize(16, 16);
      backArm.mirror = true;
      setRotation(backArm, 0F, 4.712389F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Pillar.render(f5);
    leftArm.render(f5);
    rightArm.render(f5);
    frontArm.render(f5);
    backArm.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  public void renderModel(float f, boolean renderFront, boolean renderBack, boolean renderLeft, boolean renderRight) {
	    Pillar.render(f);
	    if (renderLeft)
	    	leftArm.render(f);
	    if (renderRight)
	    	rightArm.render(f);
	    if (renderFront)
	    	frontArm.render(f);
	    if (renderBack)
	    	backArm.render(f);
  }

}