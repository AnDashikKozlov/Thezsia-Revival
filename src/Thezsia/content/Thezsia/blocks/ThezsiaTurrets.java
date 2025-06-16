package Thezsia.content.Thezsia.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.consumers.ConsumeCoolant;
import mindustry.world.draw.DrawTurret;

import static Thezsia.content.ThezItems.*;

public class ThezsiaTurrets{
    public static Block
            //Blocks
            ember, gaze;
    public static void load() {
        ember = new ItemTurret("ember"){{
            requirements(Category.turret, ItemStack.with(tantalum, 50));
            size = 3;
            squareSprite = false;
            coolant = consume(new ConsumeCoolant(0.1f, true, true));
            rotateSpeed = 3.1f;
            outlineColor = Color.valueOf("19181AFF");
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

        gaze = new PowerTurret("gaze"){{
            requirements(Category.turret, ItemStack.with(tantalum, 125, silver, 75, tensorite, 50));
            size = 3;
            coolant = consume(new ConsumeCoolant(0.1f, true, true));
            minWarmup = 0.95f; shootWarmupSpeed = 0.03f;
            consumePower(5);
            rotateSpeed = 2.5f;
            outlineColor = Color.valueOf("19181AFF");
            targetGround = true; targetAir = false;
            reload = 4;
            range = 180;
            fogRadiusMultiplier = 0.35f;
            inaccuracy = 45;
            velocityRnd = 0.2f;
            shootY = 8.7f;
            shootSound = Sounds.malignShoot;
            shake = 1;
            cooldownTime = 90;
            shootType = new MissileBulletType(){{
                smokeEffect = Fx.shootSmokeSmite; hitEffect = Fx.hitSquaresColor; despawnEffect = Fx.hitLancer;
                weaveMag = 3; weaveScale = 2;
                frontColor = trailColor = Color.valueOf("AEF2CBFF"); backColor = Color.valueOf("2CDC78FF");
                homingPower = 0.03f;
                width = height = 8;
                speed = 5.5f;
                lifetime = 40;
                despawnShake = 0.4f;
                hitShake = 0.8f;
                damage = 13;
                pierce = true; pierceCap = 2; pierceBuilding = true;
                trailLength = 20;trailWidth = 2;
            }};
            drawer = new DrawTurret("thezsia-"){{
                parts.addAll(new RegionPart("-side"){{
                                 mirror = true;
                                 under = true;
                                 outline = true;
                                 progress = PartProgress.warmup; heatProgress = PartProgress.warmup;
                                 moveX = 3; moveY = 2.5f; moveRot = -28;
                                 heatColor = Color.valueOf("2CDC78FF");
                             }},
                        new RegionPart("-mid"){{
                            mirror = true;
                            under = true;
                            outline = true;
                            progress = PartProgress.warmup; heatProgress = PartProgress.warmup;
                            moveX = 3; moveY = -0.3f; moveRot = -8;
                            heatColor = Color.valueOf("2CDC78FF");
                        }},
                        new RegionPart("-front"){{
                            mirror = true;
                            under = true;
                            outline = true;
                            progress = PartProgress.warmup; heatProgress = PartProgress.warmup;
                            moveX = 10; moveY = -3.3f; moveRot = -10;
                            heatColor = Color.valueOf("2CDC78FF");
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup;
                            circle = true;
                            hollow = true;
                            color = Color.valueOf("2CDC78FF");
                            stroke = 0; strokeTo = 1;
                            radius = 7.3f;
                            y = 8.7f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup;
                            rotateSpeed = 1;
                            sides = 3;
                            hollow = true;
                            color = Color.valueOf("2CDC78FF");
                            stroke = 0; strokeTo = 1.2f;
                            radius = 7;
                            y = 8.7f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup;
                            rotateSpeed = 0.7f;
                            sides = 3;
                            hollow = true;
                            color = Color.valueOf("2CDC78FF");
                            stroke = 0; strokeTo = 1.1f;
                            radius = 4;
                            y = 8.7f;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            rotateSpeed = -1.3f;
                            tri = true;
                            shapes = 3;
                            triLength = 0; triLengthTo = 3;
                            radius = 3;
                            haloRadius = 7; haloRotateSpeed = -1.3f;
                            color = Color.valueOf("2CDC78FF");
                            haloRotation = 180;
                            shapeRotation = 180;
                            radius = 6;
                            y = 8.7f;
                        }}
                );
            }};
        }};
    }
}