package Thezsia.content.Thezsia;

import Thezsia.content.ThezSounds;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.ai.types.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.weapons.*;

import static Thezsia.world.graphics.ThezPal.*;
import static mindustry.Vars.tilesize;
import static mindustry.content.Fx.*;

public class ThezsiaUnits {
    public static UnitType
    /* Core units */
    Iambient, IIambient,

    /* Noctis' tree */
    noctis, stella, astrum, celestia, nebula,

    /* Ignis' tree */
    ignis, flamma, ardor, incendium, infernum,

    /* Pebble's tree */
    pebble, pebbleSolid, stone;

    public static void load(){

        float coreFleeRange = 500f;

        /* Core units */
        Iambient = new UnitType("01-ambient"){{
            constructor = LegsUnit::create;
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, coreFleeRange);
            hitSize = 64f / 4f; //*sprite size / 4f*/

            legContinuousMove = allowLegStep = lockLegBase = true;
            legStraightness = 0.3f;
            legGroupSize = 4;
            legCount = 8;
            legLength = 14; legExtension = -2;
            legSpeed = 0.3f;
            legForwardScl = 0.7f;
            legMoveSpace = 1;

            speed = 1;
            accel = 0.1f;
            drag = 0.1f;
            health  = 450;
            armor = 2;
            itemCapacity  = 30;
            faceTarget = true;
            targetPriority = -2;
            outlineColor = outlineCoreunitTree;

            payloadCapacity = 2f * 2f * tilesize * tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            mineTier = 2; mineWalls = true;
            mineRange = 80; mineSpeed = 6.5f;
            buildRange = 230; buildSpeed = 0.75f;
            buildBeamOffset = 5.5f;

            hovering = true;
            groundLayer = 60;

            fogRadius = 0;
            targetable = hittable = false;

            weapons.add(new RepairBeamWeapon(){{
                    widthSinMag = 0.06f;
                    reload = 34f;
                    x = 17.4f / 4f; y = 14f / 4f;
                    rotate = false;
                    shootY = 0f;
                    beamWidth = 0.4f;
                    aimDst = 0f;
                    shootCone = 18f;
                    mirror = true;

                    repairSpeed = 1.5f / 2f; fractionRepairSpeed = 0.02f;

                    targetUnits = false; targetBuildings = true;
                    autoTarget = false;
                    controllable = true;
                    laserColor = healColor = Pal.accent;

                    bullet = new BulletType(){{maxRange = 4.5f * 8f;}};
                }});
        }};
        IIambient = new UnitType("02-ambient"){{
            constructor = LegsUnit::create;
            hitSize = 74f / 4f; //*sprite size / 4f*/

            legContinuousMove = allowLegStep = lockLegBase = true;
            legStraightness = 0.35f;
            legGroupSize = 4;
            legCount = 8;
            legLength = 19; legExtension = -4;
            legSpeed = 0.35f;
            legForwardScl = 0.7f;
            legMoveSpace = 1;

            speed = 1.25f;
            accel = 0.12f;
            drag = 0.12f;
            health  = 530;
            armor = 5;
            itemCapacity  = 50;
            faceTarget = true;
            outlineColor = outlineCoreunitTree;

            mineTier = 2; mineWalls = true;
            mineRange = 112; mineSpeed = 6.8f;
            buildRange = 262; buildSpeed = 0.82f;

            hovering = true;
            groundLayer = 60;

            fogRadius = 0;

            weapons.add(new RepairBeamWeapon(){{
                x = 18f / 4f; y = 18 / 4f;
                shootY = 0f;
                widthSinMag = 0.06f;
                reload = 34f;
                rotate = false;
                beamWidth = 0.55f;
                aimDst = 0f;
                shootCone = 30f;
                mirror = true;

                repairSpeed = 1.52f / 2f; fractionRepairSpeed = 0.036f;

                targetUnits = false; targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = healColor = Pal.accent;

                bullet = new BulletType(){{maxRange = 8f * 8f;}};
            }});
        }};
        /* Noctis' tree */
        noctis = new UnitType("noctis"){{
            constructor = LegsUnit::create;
            hitSize = 48f / 4f; //*sprite size / 4f*/
            health = 375; armor = 2;
            itemCapacity = 0;

            legContinuousMove = allowLegStep = lockLegBase = true;
            legStraightness = 0.2f;
            legGroupSize = 3;
            legCount = 6;
            legLength = 18; legExtension = -2;
            legSpeed = 0.25f;
            legForwardScl = 0.7f;
            legMoveSpace = 1.3f;
            stepShake = 0f;
            hovering = true;

            accel = 0.06f;
            drag = 0.07f;
            speed = 1;
            rotateSpeed = 4;
            outlineColor = outlineNoctisTree;

            weapons.add(new Weapon("thezsia1-noctis-gun"){{
                top = false;
                x = 0; y = 0;
                reload = 70;
                recoil = 0.6f;
                mirror = false;
                inaccuracy = 10;
                shootSound = Sounds.blaster;
                cooldownTime = 50;
                shoot.shots = 3; shoot.shotDelay = 8;
                bullet = new MissileBulletType(4.5f, 15) {{
                    lifetime = 33;
                    frontColor = Color.valueOf("bdebff"); backColor = Color.valueOf("81afe3");
                    trailColor = Color.valueOf("81afe3");
                    trailLength = 8; trailWidth = 2f;
                    smokeEffect = shootSmallSmoke;
                    shootEffect = shootSmallColor;
                    homingPower = 0.18f;
                    weaveMag = 4; weaveScale = 2;
                }};
            }});
        }};
        stella = new UnitType("stella"){{
            constructor = LegsUnit::create;
            hitSize = 64f / 4f; //*sprite size / 4f*/
            health = 760; armor = 5;
            itemCapacity = 0;

            legStraightness = 0.2f;
            legContinuousMove = allowLegStep = lockLegBase = true;
            legGroupSize = 2;
            legCount = 4;
            legLength = 25; legExtension = -2.5f;
            legSpeed = 0.22f;
            legForwardScl = 0.6f;
            legMoveSpace = 1.2f;
            hovering = true;
            stepShake = 0.1f;
            //alwaysShootWhenMoving = true;

            accel = 0.06f;
            drag = 0.07f;
            speed = 0.9f;
            rotateSpeed = 3.7f;
            outlineColor = outlineNoctisTree;

            parts.addAll(
                    new RegionPart("-shell"){{
                        layerOffset = 0.0001f;
                        mirror = true;
                        progress = PartProgress.warmup;
                        moveX = 1.5f; // moveY = -1; moveRot = -30;
                    }},
                    new RegionPart("-glow"){{
                        mirror = outline = false;
                        progress = PartProgress.recoil;
                        blending = Blending.additive;
                        colorTo = Color.valueOf("bdebff"); color = colorTo.cpy().a(0f);
                    }}
            );

            weapons.add(
                    new Weapon(){{
                        top = false;
                        x = 5f; y = 1f;
                        shootX = shootY = 0f;
                        rotate = false;
                        shootCone = 10;
                        mirror = true;
                        alternate = true;
                        reload = 7;
                        recoil = 0.7f;
                        inaccuracy = 5;
                        shootSound = Sounds.blaster;
                        shootWarmupSpeed = 0.04f; minWarmup = 0.7f; cooldownTime = 121;
                        bullet = new LaserBulletType(){{
                            damage = 12;
                            lifetime = 17;
                            recoil = 0.12f;
                            length = 57f; width = 7f;
                            sideLength = 21f; sideWidth = 0.7f; sideAngle = 21;
                            colors = new Color[]{Color.valueOf("81afe3"), Color.valueOf("bdebff")};
                            pierceDamageFactor = 0.7f;
                            smokeEffect = colorSpark;
                            shootEffect = shootSmallColor;
                            hitColor = Color.valueOf("81afe3");
                            hitEffect = Fx.hitBulletColor;
                        }};
                    }}
            );
        }};
        astrum = new UnitType("astrum"){{
            constructor = LegsUnit::create;
            hitSize = 96f / 4f; //*sprite size / 4f*/
            health = 985; armor = 12;
            itemCapacity = 0;

            legContinuousMove = allowLegStep = lockLegBase = true;
            legStraightness = 0.2f;
            legGroupSize = 2;
            legCount = 6;
            legLength = 29; legExtension = -7f;
            legSpeed = 0.25f;
            legForwardScl = 0.7f;
            legMoveSpace = 1.3f;
            stepShake = 0.2f;
            hovering = true;

            accel = 0.06f;
            drag = 0.07f;
            speed = 0.75f;
            rotateSpeed = 3.42f;
            outlineColor = outlineNoctisTree;

            parts.addAll(
                    new RegionPart("-glow"){{
                        mirror = outline = false;
                        progress = PartProgress.smoothReload;
                        blending = Blending.additive;
                        colorTo = Color.valueOf("bdebff"); color = colorTo.cpy().a(0f);
                    }}
            );

            weapons.add(
                    new Weapon("thezsia1-astrum-weapon"){{
                        top = false;
                        x = y = 0;
                        shootX = 0; shootY = 6f;
                        rotate = false;
                        shootCone = 10;
                        mirror = false;
                        reload = 184;
                        recoil = 0;
                        inaccuracy = 8;
                        shootSound = ThezSounds.blasterShot1;
                        shootWarmupSpeed = 0.03f; minWarmup = 0.85f; cooldownTime = 158;
                        bullet = new ArtilleryBulletType(){{
                            //sprite = "large-bomb";
                            parts.addAll(
                                    new FlarePart(){{
                                        mirror = false;
                                        sides = 3;
                                        radius = 5f; radiusTo = 18f;
                                        stroke = 5;
                                        rotation = 0f;
                                        y = 0f;
                                        followRotation = true;
                                        progress = PartProgress.life.slope().curve(Interp.pow3Out);
                                        color1 = Color.valueOf("bdebff"); color2 = color1.cpy().a(0f);
                                    }}
                            );
                            damage = 46;
                            splashDamage = 28; splashDamageRadius = 5 * tilesize;
                            lifetime = 184;
                            recoil = 0.58f;
                            height = width = 0; //height = 21f; width = 19f;
                            frontColor = Color.valueOf("81afe3"); backColor = Color.valueOf("bdebff");
                            pierceDamageFactor = 1.5f;
                            smokeEffect = colorSparkBig;
                            shootEffect = shootBigColor;
                            hitColor = Color.valueOf("81afe3");
                            hitEffect = despawnEffect = titanExplosionSmall;
                            hitSound = despawnSound = ThezSounds.laserShot;

                            fragSpread = 60; fragRandomSpread = 0;
                            fragBullets = 6;
                            fragBullet = new LaserBulletType(){{
                                damage = 12;
                                lifetime = 17;
                                length = 19f; width = 19f;
                                //sideLength = 41f; sideWidth = 1.7f; sideAngle = 60;
                                colors = new Color[]{Color.valueOf("81afe3"), Color.valueOf("bdebff")};
                                pierceDamageFactor = 0.7f;
                                smokeEffect = colorSpark;
                                shootEffect = none;
                                hitColor = Color.valueOf("81afe3");
                                hitEffect = Fx.hitBulletColor;
                            }};
                        }};
                        parts.add(
                                new RegionPart("-side"){{
                                    under = true; //layerOffset = -0.001f;
                                    mirror = true;
                                    progress = PartProgress.recoil;
                                    moveX = 1.75f; moveY = -1.25f; moveRot = -7;
                                }}
                        );
                    }}
            );
        }};

        /* Ignis' tree */
        ignis = new UnitType("ignis"){{
            constructor = MechUnit::create;
            hitSize = 64f / 4f; //* sprite size / 4f */
            // immunities.addAll(StatusEffects.burning);

            speed = 0.7f;
            health = 180;
            rotateSpeed = 3.4f;
            outlineColor = mechLegColor = outlineIgnisTree;

            weapons.add(
            new Weapon("thezsia1-ignis-weapon"){{
                top = false;
                x = 4.7f; y = 0;
                shootX = 0.6f; shootY = 3.4f;
                shootCone = 30;
                reload = 120;
                rotate = false;
                mirror = true;
                alternate = true;
                shootSound = Sounds.shootAlt;
                bullet = new BasicBulletType(3.7f, 10){{
                    lifetime = 40;
                    height = 14; width = 10f;
                    trailLength = 5; trailWidth = 1.3f;
                    pierce = false;
                    shootEffect = shootSmallFlame;
                    hitSound = despawnSound = ThezSounds.machineGunShot2;

                    fragOnHit = true;
                    fragSpread = 60; fragRandomSpread = 15;
                    fragBullets = 6;
                    fragBullet = new BasicBulletType(6, 1.8f){{
                        lifetime = 12;
                        height = 9; width = 6.5f;
                        hitSize = 4;
                        trailLength = 6;
                        trailWidth = 0.7f;

                        incendAmount = 1;
                        incendChance = 0.17f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 2;

                    }};
                }};
            }}
            );
        }};
        flamma = new UnitType("flamma"){{
            constructor = MechUnit::create;
            hitSize = 74f / 4f; //* sprite size (smaller side) / 4f */
            immunities.addAll(StatusEffects.burning);

            speed = 0.74f;
            health = 445;
            rotateSpeed = 3.1f;
            outlineColor = mechLegColor = outlineIgnisTree;

            weapons.add(
                    new Weapon("thezsia1-flamma-weapon"){{
                        top = false;
                        x = 9; y = 0;
                        shootX = 0.4f; shootY = 6.2f;
                        shootCone = 30;
                        recoil = 2.4f;
                        rotate = true;
                        rotateSpeed = 0.95f; rotationLimit = 20;
                        mirror = true;
                        alternate = false;
                        soundPitchMin = 0.8f; soundPitchMax = 1.1f;
                        shootSound = Sounds.torch;
                        alwaysContinuous = true;
                        continuous = true;
                        bullet = new ContinuousFlameBulletType(3.7f){{
                            length = 51; width = 2.12f;
                            colors = new Color[]{Color.valueOf("f0533ece"), Color.valueOf("ff7a5c"), Color.valueOf("ffaf96"), Color.valueOf("ffdbc2")};
                            flareLength = 11; flareWidth = 1.93f;
                            flareColor = Color.valueOf("FF5845FF");

                            status = StatusEffects.melting; statusDuration = 117;
                            hitEffect = new ParticleEffect(){{
                                cone = -75;
                                colorFrom = Color.valueOf("FF5845FF"); colorTo = Color.valueOf("FFC1BBFF");
                                line = true;
                                lifetime = 18;
                                length = 50;
                                lenFrom = 6;lenTo = 0.5f;
                                particles = 5;
                            }};
                        }};
                    }}
            );
        }};
        /* Pebble's tree */
        /*
        pebble = new UnitType("pebble"){{
            envEnabled = Env.terrestrial | Env.oxygen | Env.scorching | Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            drag = 0.04f;
            outlineColor = outlinePebbleTree;
            drawCell = false;
            speed = 1;
            rotateSpeed = 4;
            accel = 0.04f;
            health = 80; armor = 6;
            hitSize = 5;
            engineOffset = 0;
            engineSize = 0;
            itemCapacity = 0;
            useEngineElevation = false;

            legStraightness = 0.07f;
            legContinuousMove = true;
            lockLegBase = false;
            legGroupSize = 2;
            legCount = 4;
            allowLegStep = true;
            legExtension = -2;
            legLength = 8;
            legSpeed = 0.4f;
            legForwardScl = 0.4f;
            legMoveSpace = 3;
            hovering = true;

            parts.add(new RegionPart("-claw"){{
                layerOffset = -0.001f;
                progress = DrawPart.PartProgress.recoil;
                mirror = true;
                moveX = -0.3f;
                moveY = 0.5f;
                moveRot = 30;
            }});

            weapons.add(new Weapon(){{
                display = false;
                shootSound = Sounds.blaster;
                x = 0;
                y = 0;
                shootY = 0.2f;
                mirror = false;
                reload = 30;
                recoil = 0.01f;
                inaccuracy = 0;
                cooldownTime = 0;

                bullet = new BasicBulletType(){{
                    shootEffect = despawnEffect = smokeEffect = none;
                    damage = 15;
                    speed = 12;
                    lifetime = 0.65f;
                    reflectable = false;
                    absorbable = false;
                    width = height = 0;
                }};
            }});
        }};
        pebbleSolid = new UnitType("pebble-solid"){{
            envEnabled = Env.terrestrial | Env.oxygen | Env.scorching | Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            drag = 1;
            targetable = false;
            isEnemy = false;
            drawMinimap = false;
            range = 10;
            physics = false;
            lightRadius = 0;
            lightOpacity = 0;
            outlineColor = outlinePebbleTree;
            drawCell = false;
            speed = 0;
            rotateSpeed = 0;
            accel = 0;
            health = 100; armor = 5;
            hitSize = 5;
            engineOffset = 0;
            engineSize = 0;
            itemCapacity = 0;
            useEngineElevation = false;

            weapons.add(new Weapon(){{
                shootOnDeath = true;
                shootCone = 180;
                mirror = false;
                shootY = 0;
                shootSound = Sounds.explosion;
                bullet = new BasicBulletType(){{
                    rangeOverride = 70;
                    collidesTiles = false;
                    collides = false;
                    collidesAir = true;
                    hittable = false;
                    speed = 0;
                    instantDisappear = true;
                    killShooter = true;
                    spawnUnit = ThezsiaUnits.pebble;
                }};
            }});
        }};
        stone = new UnitType("stone"){{
            envEnabled = Env.terrestrial | Env.oxygen | Env.scorching | Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            drag = 0.08f;
            outlineColor = outlinePebbleTree;
            drawCell = false;
            speed = 0.9f;
            rotateSpeed = 2;
            accel = 0.04f;
            health = 190; armor = 34;
            hitSize = 9;
            engineOffset = 0;
            engineSize = 0;
            itemCapacity = 0;
            useEngineElevation = false;

            legStraightness = 0.07f;
            legContinuousMove = true;
            lockLegBase = false;
            legGroupSize = 2;
            legCount = 6;
            allowLegStep = true;
            legExtension = -2;
            legLength = 15;
            legSpeed = 0.3f;
            legForwardScl = 0.4f;
            legMoveSpace = 3;
            hovering = true;

            abilities.add(new SpawnDeathAbility(){{
                unit = ThezsiaUnits.pebble;
                amount = 4;
            }});

            parts.add(new RegionPart("-claw"){{
                layerOffset = -0.001f;
                progress = DrawPart.PartProgress.recoil;
                mirror = true;
                moveX = -0.3f; moveY = 0.5f; moveRot = 30;
            }});

            weapons.add(new Weapon(){{
                display = false;
                shootSound = Sounds.blaster;
                x = 0; y = 0;
                shootY = 0.3f;
                mirror = false;
                reload = 60;
                recoil = 0.02f;
                inaccuracy = 0;
                cooldownTime = 0;

                bullet = new BasicBulletType(){{
                    shootEffect = despawnEffect = smokeEffect = none;
                    damage = 42;
                    speed = 11;
                    lifetime = 0.85f;
                    reflectable = false; absorbable = false;
                    width = height = 0;
                }};
            }});
        }};
        */
    }
}
