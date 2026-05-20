package Thezsia.world.blocks.environment;

import Thezsia.world.graphics.Pseudo3D;
import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Prop;

/** A prop that uses pseudo 3D to make it look more like 3D */
public class FernBlock extends Prop {

    public float shadowLayer = Layer.blockProp + 1;
    public TextureRegion top, bottom;
    public float rotationScl = 120, rotationMag = 5;
    public float minBotHeight = 0.01f, maxBotHeight = 0.02f;
    public float minTopHeight = 0.03f, maxTopHeight = 0.04f;

    public FernBlock(String name) {
        super(name);
        breakable = alwaysReplace = false;
        solid = false;
        layer = Layer.light;
        customShadow = true;
    }

    public float getBotHeight(Tile tile){
        return Mathf.randomSeed(tile.x * tile.y, minBotHeight, maxBotHeight);
    }
    public float getTopHeight(Tile tile){
        return Mathf.randomSeed(tile.x * tile.y, minTopHeight, maxTopHeight);
    }

    public void load(){
        bottom = Core.atlas.find(name + "-bottom");
        top = Core.atlas.find(name + "-top");
    }

    @Override
    public void drawShadow(Tile tile) {
        Draw.z(shadowLayer);
        super.drawShadow(tile);
    }

    @Override
    public void drawBase(Tile tile) {
        float x = tile.drawx(), y = tile.drawy();
        float angle = Mathf.sin(Time.time, rotationScl, rotationMag);
        float botHeight = getBotHeight(tile);
        float topHeight = getTopHeight(tile);
        TextureRegion bottom = variants > 0 ? variantRegions[Mathf.randomSeed(tile.pos(),  0, Math.max(0, variantRegions.length - 1))] : region;
        TextureRegion top = variants > 0 ? variantRegions[Mathf.randomSeed(tile.pos(), 0, Math.max(0, variantRegions.length - 1))] : region;

        Draw.z(layer);
        Pseudo3D.rect(bottom, x, y, botHeight, angle * Draw.scl);
        Pseudo3D.rect(top, x, y, topHeight, angle * Draw.scl);
    }
}
