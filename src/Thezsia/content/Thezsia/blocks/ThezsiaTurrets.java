package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezSounds;
import Thezsia.type.bullet.PosLightningType;
import Thezsia.world.graphics.ThezPal;
import Thezsia.world.meta.ThezEnv;
import arc.graphics.Blending;
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
            shootSound = ThezSounds.UKShoot1; // Should I use Sounds.shootBreachCarbide instead?
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
                    progress = PartProgress.recoil; heatProgress = PartProgress.recoil;
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
            reload = 1.6f * 60f;
            range = 18f * Vars.tilesize;
            fogRadiusMultiplier = 0.25f;
            inaccuracy = 0.2f;
            shootY = 7;
            shootSound = Sounds.shootLancer;
            cooldownTime = 75f;
            ammoPerShot = 2;
            minWarmup = 0.8f;
            warmupMaintainTime = 90f;
            shootWarmupSpeed = 0.025f;

            ammo(
                    tensorite, new PosLightningType(38){{
                        lightningColor = hitColor = ThezPal.itemTensprite;
                        //shootSound = Sounds.shootLocus;
                        shootSound = Sounds.shootBeamPlasma;
                        boltNum = 2;
                        lightningDamage = 7;
                        lightning = 3; lightningLength = 5; lightningLengthRand = 4;
                        minRange = 5f * Vars.tilesize; maxRange = rangeOverride = 18f * Vars.tilesize;
                        hitEffect = Fx.hitLaserColor;
                        shootEffect = Fx.colorSparkBig.wrap(ThezPal.itemTensprite);
                        smokeEffect = Fx.smokePuff.wrap(ThezPal.itemTensprite);
                    }},
                    tritaniumCrystal, new PosLightningType(72){{
                        lightningColor = hitColor = ThezPal.itemTritanium;
                        shootSound = Sounds.shootBeamPlasmaSmall;
                        boltNum = 3;
                        lightningDamage = 21;
                        lightning = 7; lightningLength = 12; lightningLengthRand = 9;
                        minRange = 5f * Vars.tilesize; maxRange = rangeOverride = 25f * Vars.tilesize;
                        hitEffect = Fx.hitLaserColor;
                        shootEffect = Fx.colorSparkBig.wrap(ThezPal.itemTritanium);
                        smokeEffect = Fx.smokePuff.wrap(ThezPal.itemTritanium);

                    }}
            );
            drawer = new DrawTurret("thezsia-"){{
                parts.add(new RegionPart("-wing"){{
                    mirror = true;
                    under = false;
                    outline = true;
                    progress = PartProgress.warmup; //heatProgress = PartProgress.warmup;
                    moveX = -1.5f; moveY = -3; moveRot = 30;
                    heatColor = Color.valueOf("FFA665FF");
                }});
                parts.add(new RegionPart("-side"){{
                    mirror = true;
                    under = true;
                    outline = true;
                    progress = PartProgress.warmup; heatProgress = PartProgress.recoil;
                    moveX = 0.75f; moveY = 2.25f;
                    heatColor = Color.valueOf("FFA665FF");
                    moves.add(new PartMove(PartProgress.recoil, 0, -1.75f, -7));
                }});
                parts.add(new RegionPart("-glow"){{
                    drawRegion = false;
                    mirror = false;
                    blending = Blending.additive;
                    heatProgress = PartProgress.warmup;
                    heatColor = ThezPal.powerColorMid; //Color.valueOf("FFA665FF");
                }});
                parts.add(new RegionPart("-shoot-glow"){{
                    drawRegion = false;
                    mirror = false;
                    blending = Blending.additive;
                    heatProgress = PartProgress.heat;
                    heatColor = ThezPal.powerColorLight;
                }});
            }};
        }};
    }
}