package Thezsia.world.blocks.power;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.*;
import Thezsia.world.interfaces.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.blocks.power.*;
import mindustry.world.meta.*;

import static arc.math.geom.Mat3D.rot;
import static mindustry.Vars.renderer;

//absurd
//code fro dusted lands :/
public class TransferPowerConsumeGenerator extends ConsumeGenerator {

    public float radius = 60f * 8f;

    public TransferPowerConsumeGenerator(String name) {
        super(name);
    }

    @Override
    public void init() {
        clipSize = Math.max(clipSize, radius * 2f);
        super.init();
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.add(Stat.powerRange, radius / Vars.tilesize, StatUnit.blocks);
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("power-status", PowerNode.makePowerBalance());
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);

        Drawf.dashCircle(x * Vars.tilesize, y * Vars.tilesize, radius, Pal.accent);
    }



    public class TransferPowerConsumeGeneratorBuild extends ConsumeGeneratorBuild implements TransferPowerc {

        public int lastChange = -2;

        @Override
        public void updateTile() {
            super.updateTile();
            updateTransfer();
        }

        @Override
        public void drawLight() {
            Drawf.light(x, y, (40f + Mathf.absin(10f, 5f)) * Math.min(productionEfficiency, 2f) * size, Color.scarlet, 0.4f);
        }

        @Override
        public void drawSelect() {
            super.drawSelect();
            Drawf.dashCircle(x, y, radius, Pal.accent);
        }


        @Override
        public Building build() {
            return this;
        }

        @Override
        public float radius() {
            return radius;
        }

        @Override
        public int lastChange() {
            return lastChange;
        }

        @Override
        public void lastChange(int change) {
            lastChange = change;
        }

        @Override
        public void draw() {
            super.draw();
            drawEbalJavu();
        }
        public void drawEbalJavu(){
            if(radius > 0.001f){
                Draw.color(team.color, Color.white, Mathf.clamp(0.08f));

                if(renderer.animateShields){
                    Draw.z(Layer.shields - 0.001f);
                    Fill.poly(x, y, 60, radius, 0);
                }else{
                    Draw.z(Layer.shields - 0.002f);
                    Lines.stroke(1.5f);
                    Draw.alpha(0.04f + Mathf.clamp(0.08f));
                    Fill.poly(x, y, 60, radius, 0);
                    Draw.alpha(0.5f);
                    Lines.poly(x, y, 60, radius, 0);
                    Draw.reset();
                }
            }
        }
    }
}
