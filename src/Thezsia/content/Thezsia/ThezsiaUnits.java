package Thezsia.content.Thezsia;

import Thezsia.world.meta.ThezEnv;
import arc.graphics.Color;
import mindustry.ai.types.*;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.Env;

import static Thezsia.world.graphics.ThezPal.*;
import static mindustry.Vars.tilesize;
import static mindustry.content.Fx.*;

public class ThezsiaUnits {
    public static UnitType
    //core
    Iambient, IIambient,
    //Noctis tree
    noctis, stella, astrum,
    //Ignis tree
    ignis, flamma,
    //Pebble tree
    pebble, pebbleSolid, stone;

    public static void load(){

        float coreFleeRange = 500f;

        Iambient = new UnitType("01-ambient"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, coreFleeRange);

            speed = 1;
            accel = 0.1f;
            drag = 0.1f;
            health  = 450;
            armor = 2;
            hitSize = 7;
            itemCapacity  = 30;
            faceTarget = true;
            targetPriority = -2;
            outlineColor = outlineCoreunitTree;

            payloadCapacity = 2f * 2f * tilesize * tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            mineTier = 2;
            mineWalls = true;
            mineRange = 80;
            mineSpeed = 6.5f;
            buildRange = 230;
            buildSpeed = 0.75f;
            buildBeamOffset = 5.5f;

            legStraightness = 0.3f;
            legContinuousMove = true;
            lockLegBase = true;
            legGroupSize = 4;
            legCount = 8;
            allowLegStep = true;
            legExtension = -2;
            legLength = 14;
            legSpeed = 0.3f;
            legForwardScl = 0.7f;
            legMoveSpace = 1;
            hovering = true;
            groundLayer = 60;

            fogRadius = 0;
            targetable = false;
            hittable = false;

            weapons.add(new RepairBeamWeapon(){{
                    widthSinMag = 0.06f;
                    reload = 34f;
                    x = 17.4f / 4f;
                    y = 14f / 4f;
                    rotate = false;
                    shootY = 0f;
                    beamWidth = 0.4f;
                    aimDst = 0f;
                    shootCone = 18f;
                    mirror = true;

                    repairSpeed = 1.5f / 2f;
                    fractionRepairSpeed = 0.02f;

                    targetUnits = false;
                    targetBuildings = true;
                    autoTarget = false;
                    controllable = true;
                    laserColor = Pal.accent;
                    healColor = Pal.accent;

                    bullet = new BulletType(){{
                        maxRange = 4.5f * 8;
                    }};
                }});
        }};
        IIambient = new UnitType("02-ambient"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            speed = 1.25f;
            accel = 0.12f;
            drag = 0.12f;
            health  = 530;
            armor = 5;
            hitSize = 9;
            itemCapacity  = 50;
            faceTarget = true;
            outlineColor = outlineCoreunitTree;

            mineTier = 2;
            mineWalls = true;
            mineRange = 112;
            mineSpeed = 6.8f;
            buildRange = 262;
            buildSpeed = 0.82f;

            legStraightness = 0.35f;
            legContinuousMove = true;
            lockLegBase = true;
            legGroupSize = 4;
            legCount = 8;
            allowLegStep = true;
            legExtension = -4;
            legLength = 19;
            legSpeed = 0.35f;
            legForwardScl = 0.7f;
            legMoveSpace = 1;
            hovering = true;
            groundLayer = 60;

            fogRadius = 0;

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.06f;
                reload = 34f;
                x = 18f / 4f;
                y = 18 / 4f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.55f;
                aimDst = 0f;
                shootCone = 30f;
                mirror = true;

                repairSpeed = 1.52f / 2f;
                fractionRepairSpeed = 0.036f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 8f * 8;
                }};
            }});
        }};
        //Noctis tree
        noctis = new UnitType("noctis"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            drag = 0.07f;
            speed = 1;
            rotateSpeed = 4;
            outlineColor = outlineNoctisTree;

            accel = 0.06f;
            health = 175;
            armor = 1;
            hitSize = 10;
            itemCapacity = 0;

            legStraightness = 0.2f;
            legContinuousMove = true;
            lockLegBase = true;
            legGroupSize = 3;
            legCount = 6;
            allowLegStep = true;
            legExtension = -2;
            legLength = 14;
            legSpeed = 0.25f;
            legForwardScl = 0.7f;
            legMoveSpace = 1.3f;
            hovering = true;

            weapons.add(new Weapon("thezsia1-noctis-gun"){{
                top = false;
                x = 0;
                y = 0;
                reload = 70;
                recoil = 0.7f;
                mirror = false;
                inaccuracy = 10;
                shootSound = Sounds.blaster;
                cooldownTime = 50;
                shoot.shots = 3;
                shoot.shotDelay = 8;
                bullet = new MissileBulletType(4.5f, 10) {{
                    homingPower = 0.18f;
                    weaveMag = 4;
                    weaveScale = 2;
                    trailLength = 8;
                    trailWidth = 2f;
                    lifetime = 33;
                    frontColor = Color.valueOf("FFFFFFFF");
                    backColor = Color.valueOf("869CBEFF");
                    trailColor = Color.valueOf("869CBEFF");
                }};
            }});
        }};
        stella = new UnitType("stella"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            drag = 0.07f;
            speed = 0.9f;
            rotateSpeed = 3.7f;
            outlineColor = outlineNoctisTree;

            accel = 0.06f;
            health = 460;
            armor = 4;
            hitSize = 14;
            itemCapacity = 0;

            legStraightness = 0.2f;
            legContinuousMove = true;
            lockLegBase = true;
            legGroupSize = 2;
            legCount = 4;
            allowLegStep = true;
            legExtension = -2.5f;
            legLength = 19;
            legSpeed = 0.25f;
            legForwardScl = 0.7f;
            legMoveSpace = 1.3f;
            hovering = true;
            alwaysShootWhenMoving = true;

            parts.addAll(
                    new RegionPart("-shell"){{
                        mirror = true;
                        progress = PartProgress.warmup;
                        moveX = 0.9f;
                        moveY = -1;
                        moveRot = -30;
                    }}
            );

            weapons.add(new Weapon("thezsia1-stella-weapon"){{
                top = false;
                x = 0;
                y = -0.0f;
                rotate = false;
                shootCone = 30;
                shootX = 5;
                mirror = true;
                alternate = true;
                reload = 4;
                recoil = 0.7f;
                inaccuracy = 5;
                shootSound = Sounds.blaster;
                cooldownTime = 50;
                shootWarmupSpeed = 0.04f;
                minWarmup = 0.8f;
                bullet = new BasicBulletType(5.5f, 7) {{
                    smokeEffect = shootBigSmoke;
                    shootEffect = shootBigColor;
                    trailLength = 10;
                    trailWidth = 1.5f;
                    height = 7.3f;
                    width = 6.9f;
                    lifetime = 18;
                    frontColor = Color.valueOf("FFFFFFFF");
                    backColor = Color.valueOf("869CBEFF");
                    trailColor = Color.valueOf("869CBEFF");
                }};
            }});
        }};
        astrum = new UnitType("astrum"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = LegsUnit::create;

            drag = 0.07f;
            speed = 0.75f;
            rotateSpeed = 3.42f;
            outlineColor = outlineNoctisTree;

            accel = 0.06f;
            health = 985;
            armor = 6;
            hitSize = 20;
            itemCapacity = 0;

            legStraightness = 0.2f;
            legContinuousMove = true;
            lockLegBase = true;
            legGroupSize = 2;
            legCount = 6;
            allowLegStep = true;
            legExtension = -7f;
            legLength = 27;
            legSpeed = 0.25f;
            legForwardScl = 0.7f;
            legMoveSpace = 1.3f;
            hovering = true;
            alwaysShootWhenMoving = true;

            parts.addAll(
                    new RegionPart("-shell"){{
                        mirror = true;
                        progress = PartProgress.warmup;
                        moveX = 0.8f;
                        moveY = -1.1f;
                        moveRot = -24;
                    }}
            );

            weapons.add(
            new Weapon("thezsia1-astrum-shellweapon"){{
                top = false;
                x = 0;
                y = 0;
                shootX = 9.9f;
                shootY = 1.8f;
                rotate = false;
                shootCone = 30;
                mirror = true;
                alternate = true;
                reload = 7;
                recoil = 0.82f;
                inaccuracy = 8;
                shootSound = Sounds.blaster;
                cooldownTime = 68;
                shootWarmupSpeed = 0.028f;
                minWarmup = 0.96f;
                bullet = new MissileBulletType(5.9f, 12) {{
                    smokeEffect = shootBigSmoke;
                    shootEffect = shootBigColor;
                    homingPower = 0.35f;
                    weaveMag = 5;
                    weaveScale = 2.65f;
                    trailLength = 14;
                    trailWidth = 2.7f;
                    lifetime = 25;
                    frontColor = Color.valueOf("FFFFFFFF");
                    backColor = Color.valueOf("869CBEFF");
                    trailColor = Color.valueOf("869CBEFF");
                }};
            }},
            new Weapon("thezsia1-astrum-gun"){{
                top = false;
                x = 0;
                y = 0f;
                shootX = 0;
                shootY = 6.8f;
                mirror = false;
                rotate = false;
                recoil = 0.78f;
                reload = 267;
                cooldownTime = 152;
                heatColor = Color.valueOf("e5f1ffdb");
                shootSound = Sounds.laser;
                shoot.shots = 4;
                shoot.firstShotDelay= 104;
                shoot.shotDelay = 68;
                bullet = new LaserBulletType(10) {{
                    length = 72;
                    width = 9;
                    lifetime = 32;
                    colors = new Color[]{Color.valueOf("869CBEFF"), Color.valueOf("b8dbf5"), Color.valueOf("FFFFFFFF")};
                    shootEffect = new MultiEffect(lightningShoot, lightningCharge);
                    hitEffect = hitLancer;
                }};
            }}
            );
        }};
        //Ignis tree
        ignis = new UnitType("ignis"){{
            envEnabled = Env.oxygen; envDisabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = MechUnit::create;
            immunities.addAll(StatusEffects.burning);

            speed = 0.7f;
            health = 180;
            hitSize = 9;
            rotateSpeed = 3.4f;
            outlineColor = outlineIgnisTree;
            mechLegColor = outlineIgnisTree;

            weapons.add(
            new Weapon("thezsia1-ignis-weapon"){{
                top = false;
                x = 4.7f;
                y = 0;
                shootX = 0.6f;
                shootY = 3.2f;
                shootCone = 30;
                reload = 120;
                rotate = false;
                mirror = true;
                alternate = true;
                shootSound = Sounds.shootAlt;
                bullet = new BasicBulletType(3.7f, 10){{
                    lifetime = 40;
                    height = 14;
                    width = 8f;
                    trailLength = 5;
                    trailWidth = 1.3f;
                    pierce = false;
                    shootEffect = shootSmallFlame;

                    fragRandomSpread = 0;
                    fragSpread = 60;
                    fragOnHit = true;
                    fragBullets = 6;
                    fragBullet = new BasicBulletType(6, 1.8f){{
                        lifetime = 15;
                        height = 9;
                        width = 6.5f;
                        hitSize = 4;
                        trailLength = 6;
                        trailWidth = 0.7f;

                        incendAmount = 1;
                        incendChance = 0.17f;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 5;

                    }};
                }};
            }}
            );
        }};
        flamma = new UnitType("flamma"){{
            envEnabled = Env.oxygen; envDisabled = Env.underwater | ThezEnv.underwaterWarm;
            constructor = MechUnit::create;
            immunities.addAll(StatusEffects.burning);

            speed = 0.74f;
            health = 445;
            hitSize = 14;
            rotateSpeed = 3.1f;
            outlineColor = outlineIgnisTree;
            mechLegColor = outlineIgnisTree;

            weapons.add(
                    new Weapon("thezsia1-flamma-weapon"){{
                        top = false;
                        x = 9;
                        y = 0;
                        shootX = 0.4f;
                        shootY = 6.2f;
                        shootCone = 30;
                        recoil = 2.4f;
                        rotate = true;
                        rotateSpeed = 0.95f;
                        rotationLimit = 20;
                        mirror = true;
                        alternate = false;
                        soundPitchMin = 0.8f;
                        soundPitchMax = 1.1f;
                        shootSound = Sounds.torch;
                        alwaysContinuous = true;
                        continuous = true;
                        bullet = new ContinuousFlameBulletType(3.7f){{
                            length = 51;
                            width = 2.12f;
                            colors = new Color[]{Color.valueOf("f0533ece"), Color.valueOf("ff7a5c"), Color.valueOf("ffaf96"), Color.valueOf("ffdbc2")};
                            flareLength = 11;
                            flareWidth = 1.93f;
                            flareColor = Color.valueOf("FF5845FF");

                            status = StatusEffects.melting;
                            statusDuration = 117;
                            hitEffect = new ParticleEffect(){{
                                cone = -75;
                                colorFrom = Color.valueOf("FF5845FF");
                                colorTo = Color.valueOf("FFC1BBFF");
                                line = true;
                                lifetime = 18;
                                length = 50;
                                lenFrom = 6;
                                lenTo = 0.5f;
                                particles = 5;
                            }};
                        }};
                    }}
            );
        }};
        //pebble tree
        pebble = new UnitType("pebble"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.scorching;
            constructor = LegsUnit::create;

            drag = 0.04f;
            outlineColor = outlinePebbleTree;
            drawCell = false;
            speed = 1;
            rotateSpeed = 4;
            accel = 0.04f;
            health = 80;
            armor = 6;
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
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.scorching;
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
            health = 100;
            armor = 5;
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
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.scorching;
            constructor = LegsUnit::create;

            drag = 0.08f;
            outlineColor = outlinePebbleTree;
            drawCell = false;
            speed = 0.9f;
            rotateSpeed = 2;
            accel = 0.04f;
            health = 190;
            armor = 34;
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
                moveX = -0.3f;
                moveY = 0.5f;
                moveRot = 30;
            }});

            weapons.add(new Weapon(){{
                display = false;
                shootSound = Sounds.blaster;
                x = 0;
                y = 0;
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
                    reflectable = false;
                    absorbable = false;
                    width = height = 0;
                }};
            }});
        }};
    }
}
