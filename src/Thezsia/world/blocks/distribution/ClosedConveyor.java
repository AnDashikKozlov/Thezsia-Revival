package Thezsia.world.blocks.distribution;
import arc.Core;
import arc.graphics.g2d.*;
import arc.math.geom.Geometry;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.world.blocks.distribution.Conveyor;
import static mindustry.Vars.tilesize;
public class ClosedConveyor extends Conveyor {
    public TextureRegion[] convRegions;
    public TextureRegion capRegion;
    public ClosedConveyor(String name) {
        super(name);
    }
    @Override
    public void load() {
        super.load();
        convRegions = new TextureRegion[5];
        for (int i = 0; i < convRegions.length; i++) {
            convRegions[i] = Core.atlas.find(name + "-top-" + i);
            capRegion = Core.atlas.find(name + "-cap");
        }
        uiIcon = fullIcon = editorIcon = Core.atlas.find(name + "-full");
    }
    @SuppressWarnings("unused")
    public class ClosedConveyorBuild extends ConveyorBuild {
        public boolean capped, backCapped = false;
        @Override
        public void draw() {
            super.draw();
            if(capped && capRegion.found()) Draw.rect(capRegion, x, y, rotdeg());
            if(backCapped && capRegion.found()) Draw.rect(capRegion, x, y, rotdeg() + 180);
            //draw extra conveyor pipes facing this one for non-square tiling purposes
            Draw.z(Layer.blockUnder + 0.1f);
            for(int i = 0; i < 4; i++){
                if((blending & (1 << i)) != 0){
                    int dir = rotation - i;
                    float rot = i == 0 ? rotation * 90 : (dir)*90;
                    Draw.rect(sliced(convRegions[0], i != 0 ? SliceMode.bottom : SliceMode.top), x + Geometry.d4x(dir) * tilesize*0.75f, y + Geometry.d4y(dir) * tilesize*0.75f, rot);
                }
            }
            Draw.z(Layer.block - 0.05f);
            Draw.rect(convRegions[blendbits], x, y, tilesize * blendsclx, tilesize * blendscly, rotation * 90);
        }
        @Override
        public void unitOn(Unit unit) {
            //no
        }
        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();
            Building prev = back();
            capped = next == null || next.team != team || !next.block.hasItems;
            backCapped = blendbits == 0 && (prev == null || prev.team != team || !prev.block.hasItems);
        }
    }
}