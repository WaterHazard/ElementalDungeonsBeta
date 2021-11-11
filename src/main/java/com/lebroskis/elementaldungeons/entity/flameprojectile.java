package com.lebroskis.elementaldungeons.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;


public class flameprojectile extends AbstractFireballEntity{



    public flameprojectile(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityType.FIREBALL, shooter, accelX, accelY, accelZ, worldIn);

    }
    public int explosionPower = 2;
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world,
                    this.getShooter());
            this.world.createExplosion((Entity)null, this.getPosX(), this.getPosY(), this.getPosZ(),
                    (float)this.explosionPower, flag, flag ? Explosion.Mode.NONE : Explosion.Mode.NONE);
          this.remove();
        }
    }

    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (!this.world.isRemote) {
            Entity entity = result.getEntity();
            Entity entity1 = this.getShooter();
            entity.attackEntityFrom(DamageSource.causeOnFireDamage(this, entity1), 2.5F);
            if (entity1 instanceof LivingEntity) {
                entity.setFire(5);
            }
        }
    }
}
