package Thezsia.content.Thezsia.blocks;

import Thezsia.type.bullet.PosLightningType;
import Thezsia.world.graphics.ThezPal;
import Thezsia.world.meta.ThezEnv;
import arc.graphics.Color;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.consumers.ConsumeCoolant;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.Env;

import static Thezsia.content.ThezItems.*;

public class ThezsiaTurrets{
    public static Block
            //Blocks
            ember, stinger;
    public static void load() {
        ember = new ItemTurret("ember"){{
            requirements(Category.turret, ItemStack.with(tantalum, 50));
            size = 3;
            squareSprite = false;
            coolant = consume(new ConsumeCoolant(0.1f, true, true));
            rotateSpeed = 3.1f;
            outlineColor = ThezPal.outlineTurret;
            targetAir = false;
            targetGround = true;
            reload = 82f;
            range = 200f;
            fogRadiusMultiplier = 0.5f;
            inaccuracy = 2;
            shootY = 2;
            shootSound = Sounds.largeCannon;
            cooldownTime = 90f;
            ammoPerShot = 5;
            minWarmup = 0.5f;
            shootWarmupSpeed = 0.03f;
            ammo(
                    nihilite, new BasicBulletType(){{
                        ammoMultiplier = 2;
                        shootEffect = Fx.shootTitan; smokeEffect = Fx.shootSmokeTitan;
                        width = 8; height = 10;
                        //sprite =
                        speed = 5.5f;
                        lifetime = 36.36f;
                        pierce = true; pierceCap = 3; pierceBuilding = true;
                        damage = 10;
                        trailLength = 8; trailWidth = 2;
                    }},
                    infium, new BasicBulletType(){{
                        ammoMultiplier = 1;
                        shootEffect = Fx.shootTitan; smokeEffect = Fx.shootSmokeTitan;
                        width = 9.4f; height = 13.4f;
                        //sprite =
                        speed = 5.7f;
                        lifetime = 38.59f;
                        damage = 13;
                        rangeChange = 20;
                        pierceCap = 4; pierceBuilding = true;
                        trailLength = 9; trailWidth = 2.3f;
                        fragRandomSpread = 7; fragOnHit = true; fragSpread = 30; fragBullets = 5;
                        fragBullet = new BasicBulletType(){{
                            width = 4.5f; height = 7.5f;
                            lifetime = 28;
                            speed = 3.25f;
                            damage = 3;
                            pierceCap = 2; pierceBuilding = true;
                            hitSize = 4;
                            trailLength = 7; trailWidth = 1.3f;
                        }};
                    }}
            );
            drawer = new DrawTurret("thezsia-"){{
                parts.add(new RegionPart("-side"){{
                    mirror = true;
                    under = true;
                    outline = true;
                    progress = PartProgress.recoil; heatProgress = PartProgress.warmup;
                    moveX = 0.7f; moveY = -0.8f; moveRot = -18;
                    heatColor = Color.valueOf("FFA665FF");
                }});
            }};
        }};
        stinger = new ItemTurret("stinger"){{
            requirements(Category.turret, ItemStack.with(tantalum, 110, silver, 40, infium, 75));
            size = 3;
            squareSprite = false;
            coolant = consume(new ConsumeCoolant(0.25f, true, true));
            rotateSpeed = 2.1f;
            outlineColor = ThezPal.outlineTurret;
            targetAir = false;
            targetGround = true;
            reload = 1.3f * 60f;
            range = 18f * Vars.tilesize;
            fogRadiusMultiplier = 0.25f;
            inaccuracy = 0.2f;
            shootY = 2;
            shootSound = Sounds.laser;
            //cooldownTime = 90f;
            ammoPerShot = 5;
            //minWarmup = 0.5f;
            //shootWarmupSpeed = 0.03f;

            ammo(
                    tensorite, new PosLightningType(38){{
                        lightningColor = hitColor = ThezPal.itemTensprite;
                        shootSound = Sounds.spark;
                        boltNum = 3;
                        lightningDamage = 7;
                        lightning = 3; lightningLength = 5; lightningLengthRand = 12;
                        minRange = 5f * Vars.tilesize; maxRange = rangeOverride = 18f * Vars.tilesize;
                        hitEffect = Fx.hitLaserColor;
                        smokeEffect = Fx.greenCloud.wrap(ThezPal.itemTensprite);
                    }},
                    tritaniumCrystal, new PosLightningType(72){{
                        lightningColor = hitColor = ThezPal.itemTritaniumcrystal;
                        shootSound = Sounds.spark;
                        boltNum = 5;
                        lightningDamage = 21;
                        lightning = 7; lightningLength = 12; lightningLengthRand = 19;
                        minRange = 5f * Vars.tilesize; maxRange = rangeOverride = 25f * Vars.tilesize;
                        hitEffect = Fx.hitLaserColor;
                        smokeEffect = Fx.greenCloud.wrap(ThezPal.itemTritaniumcrystal);

                    }}
            );
        }};
    }
}