package Thezsia.content.Thezsia.blocks;

import Thezsia.world.graphics.ThezPal;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.draw.*;

import static Thezsia.content.ThezItems.*;
import static arc.math.Interp.pow2;
import static arc.math.Interp.pow2Out;

public class ThezsiaDefence{
    public static Block
            //walls
            tantalumWall, TantalumWallLarge, infiumWall, InfiumWallLarge, tensoriteWall, TensoriteWallLarge, tritaniumWall, TritaniumWallLarge, crackedWall, largeCrackedWall,
            //effects
            renewer, barrierProjector;
    public static void load(){
        //walls
        tantalumWall = new Wall("tantalum-wall"){{
            requirements(Category.defense, ItemStack.with(tantalum, 6));
            size = 1; health = 360;
        }};
        TantalumWallLarge = new Wall("tantalum-wall-large"){{
            requirements(Category.defense, ItemStack.with(tantalum, 24));
            size = 2; health = 1440;
        }};
        infiumWall = new Wall("infium-wall"){{
            requirements(Category.defense, ItemStack.with(infium, 6));
            size = 1; health = 440;
        }};
        InfiumWallLarge = new Wall("infium-wall-large"){{
            requirements(Category.defense, ItemStack.with(infium, 24));
            size = 2; health = 1760;
        }};
        tensoriteWall = new Wall("tensorite-wall"){{
            requirements(Category.defense, ItemStack.with(tensorite, 6));
            size = 1; health = 560;
            destroyBullet = new BasicBulletType(0, 26){{
                lifetime = 0.1f;
                width = height = 6; sprite = "thezsia1-none-bullet"; backColor = frontColor = ThezPal.itemTensprite;
                hitEffect = despawnEffect = new MultiEffect(){{
                    new ParticleEffect(){{
                        lifetime = 1.7f * 60f;
                        baseLength = 15; length = 34;
                        interp = Interp.pow2; sizeInterp = Interp.pow2Out;
                        sizeFrom = 3; sizeTo = 1;
                        baseRotation = 0; cone = 360;
                        colorFrom = ThezPal.itemTensprite; colorTo = Color.valueOf("0a0b0d00");
                    }};
                    new ParticleEffect(){{
                        lifetime = 3f * 60f;
                        line = true; lenFrom = 3; lenTo = 0.2f;
                        baseLength = 15; length = 34;
                        interp = Interp.pow2; sizeInterp = Interp.pow2Out;
                        sizeFrom = 3; sizeTo = 1;
                        baseRotation = 0; cone = 360;
                        colorFrom = ThezPal.itemTensprite; colorTo = Color.valueOf("0a0b0d00");
                    }};
                }};
                hitColor = ThezPal.itemTensprite;
                splashDamage = 7; splashDamageRadius = 3.1f * 8f;
            }};
        }};
        TensoriteWallLarge = new Wall("tensorite-wall-large"){{
            requirements(Category.defense, ItemStack.with(tensorite, 24));
            size = 2; health = 2240;
            destroyBullet = new BasicBulletType(0, 26){{
                lifetime = 0.1f;
                width = height = 14; sprite = "thezsia1-none-bullet"; backColor = frontColor = ThezPal.itemTensprite;
                hitEffect = despawnEffect = new MultiEffect(){{
                    new ParticleEffect(){{
                        lifetime = 2.1f * 60f;
                        baseLength = 19; length = 44;
                        interp = Interp.pow2; sizeInterp = Interp.pow2Out;
                        sizeFrom = 4; sizeTo = 1;
                        baseRotation = 0; cone = 360;
                        colorFrom = ThezPal.itemTensprite; colorTo = Color.valueOf("0a0b0d00");
                    }};
                    new ParticleEffect(){{
                        lifetime = 4f * 60f;
                        line = true; lenFrom = 3; lenTo = 0.2f;
                        baseLength = 19; length = 44;
                        interp = Interp.pow2; sizeInterp = Interp.pow2Out;
                        sizeFrom = 4; sizeTo = 1;
                        baseRotation = 0; cone = 360;
                        colorFrom = ThezPal.itemTensprite; colorTo = Color.valueOf("0a0b0d00");
                    }};
                }};
                hitColor = ThezPal.itemTensprite;
                splashDamage = 13; splashDamageRadius = 5.6f * 8f;
            }};
        }};
        tritaniumWall = new RegenProjector("tritanium-wall"){{
            requirements(Category.defense, ItemStack.with(tritanium, 6, sulfur, 4));
            health = 410; size = 1;
            baseColor = Color.valueOf("2CDC78FF");
            range = 1; healPercent = 0.005f;
            effect = new ParticleEffect(){{
                colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                particles = 3;
                line = false;
                strokeFrom = 0.7f; strokeTo = 1.8f;
                lifetime = 80;
                cone = 360;
                interp = pow2; sizeInterp = pow2Out;
            }};
            drawer = new DrawMulti(
                    new DrawDefault()
            );
        }};
        TritaniumWallLarge = new RegenProjector("tritanium-wall-large"){{
            requirements(Category.defense, ItemStack.with(tritanium, 24, sulfur, 16));
            health = 1640; size = 2;
            baseColor = Color.valueOf("2CDC78FF");
            range = 2; healPercent = 0.005f;
            effect = new ParticleEffect(){{
                colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                particles = 3;
                line = false;
                strokeFrom = 0.7f; strokeTo = 1.8f;
                lifetime = 80;
                cone = 360;
                interp = pow2; sizeInterp = pow2Out;
            }};
            drawer = new DrawMulti(new DrawDefault());
        }};
        crackedWall = new Wall("cracked-wall"){{
            requirements(Category.defense, ItemStack.with(silver, 4));
            health = 165; size = 1; variants = 3;
        }};
        largeCrackedWall = new Wall("large-cracked-wall"){{
            requirements(Category.defense, ItemStack.with(silver, 19));
            health = 471; size = 2; variants = 3;
        }};
        //"effects"
        renewer = new RegenProjector("renewer"){{
            requirements(Category.effect, ItemStack.with(tantalum, 40, tensorite, 30, tritaniumCrystal, 15));
            health = 185; size = 2; squareSprite = false;

            baseColor = Color.valueOf("2CDC78FF");
            range = 14; healPercent = 0.013f;

            consumePower(1.87f);
            consumeItem(tritanium).boost();
            effect = new ParticleEffect(){{
                colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                particles = 4;
                line = false;
                strokeFrom = 0.6f; strokeTo = 1.9f;
                lifetime = 85;
                cone = 360;
                interp = pow2; sizeInterp = pow2Out;
            }};

            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawParticles(){{
                        particleRad = 5; particleLife = 120; particleSize = 3;
                        alpha = 0.5f;
                        color = Color.valueOf("2CDC78");
                        reverse = true;
                    }}, new DrawDefault());
        }};
        barrierProjector = new ForceProjector("barrier-projector"){{
            requirements(Category.effect, ItemStack.with(tantalum, 80, tensorite, 50, sulfur, 15, tritaniumCrystal, 25));
            size = 3;
            squareSprite = false;

            consumePower(2.185f);
            //consumeItem(ThezItems.tritanium).boost();
            itemConsumer = consumeItem(tritanium).boost();

            cooldownNormal = 2.65f;
            cooldownLiquid = 2.5f;
            cooldownBrokenBase = 1.15f;
            coolantConsumption = 0.2f;

            radius = 128;
            phaseRadiusBoost = 96;
            phaseShieldBoost = 200;
            phaseUseTime = 190;

            shieldHealth = 1200;
            shieldRotation = 0;
            sides = 4; //4, 12
            solid = true;
            canOverdrive = true;
        }};
    }
}