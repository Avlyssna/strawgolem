package nivoridocs.strawgolem.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * StrawGolem - NivOridocs
 * Created using Tabula 7.0.0
 */
public class ModelStrawGolem extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightArm;
    private final ModelRenderer leftArm;

	public ModelStrawGolem() {
        textureWidth = 48;
        textureHeight = 48;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 11.0F, 0.0F);
        head.setTextureOffset(26, 24);
        head.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4, false);
        head.setTextureOffset(11, 32);
        head.addBox(-2.0F, -5.0F, -2.0F, 4, 1, 4, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(20, 32);
        body.addBox(-4.0F, -13.0F, -3.0F, 8, 10, 6, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-2.0F, 21.0F, 0.0F);
        rightleg.setTextureOffset(12, 43);
        rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(2.0F, 21.0F, 0.0F);
        leftleg.setTextureOffset(12, 43);
        leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, false);

        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(-5.0F, 12.0F, 0.0F);
        rightArm.setTextureOffset(4, 39);
        rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, false);

        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(5.0F, 12.0F, 0.0F);
        leftArm.setTextureOffset(4, 39);
        leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, false);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        head.render(f5);
        body.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        rightArm.render(f5);
        leftArm.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;

        this.body.rotateAngleY = 0.0F;

        float auxLimbSwing = limbSwing * 5.0F * 0.6662F;

        float swingAmountArm = 1.7F * limbSwingAmount;
        float swingAmoungLeg = 2.5F * limbSwingAmount;

        this.rightArm.rotateAngleX = MathHelper.cos(auxLimbSwing + (float) Math.PI) * swingAmountArm;
        this.leftArm.rotateAngleX = MathHelper.cos(auxLimbSwing) * swingAmountArm;
        this.rightArm.rotateAngleZ = 0.0F;
        this.leftArm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(auxLimbSwing) * swingAmoungLeg;
        this.leftleg.rotateAngleX = MathHelper.cos(auxLimbSwing + (float) Math.PI) * swingAmoungLeg;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
        this.rightleg.rotateAngleZ = 0.0F;
        this.leftleg.rotateAngleZ = 0.0F;

        this.rightArm.rotateAngleY = 0.0F;
        this.rightArm.rotateAngleZ = 0.0F;

        this.leftArm.rotateAngleY = 0.0F;

        this.rightArm.rotateAngleY = 0.0F;

        this.body.rotateAngleX = 0.0F;

        if (!((EntityLivingBase)entityIn).getHeldItemMainhand().isEmpty()) {
            this.rightArm.rotateAngleX = (float) -(0.29D * Math.PI);
            this.rightArm.rotateAngleY = (float) -(0.12D * Math.PI);
            this.rightArm.rotateAngleZ = (float) (0.08D * Math.PI);
            this.leftArm.rotateAngleX = (float) -(0.29D * Math.PI);
            this.leftArm.rotateAngleY = (float) (0.12D * Math.PI);
            this.leftArm.rotateAngleZ = (float) -(0.08D * Math.PI);
        } else {
            this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.06F + 0.06F;
            this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.06F + 0.06F;
            this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.06F;
            this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.06F;
        }

	}
}
