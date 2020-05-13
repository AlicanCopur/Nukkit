package cn.nukkit.event.block;

import cn.nukkit.block.Block;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;

/**
 * author: AlicanCopur
 * Nukkit Project
 */
public class BlockChangeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    public Block blockPrevious;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public BlockChangeEvent(Block block, Block blockPrevious) {
        super(block);
        this.blockPrevious = blockPrevious;
    }
    public Block getPrevious(){
        return this.blockPrevious;
    }
}
