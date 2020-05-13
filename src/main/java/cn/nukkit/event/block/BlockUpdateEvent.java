package cn.nukkit.event.block;

import cn.nukkit.block.Block;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class BlockUpdateEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private Block blockPrevious;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public BlockUpdateEvent(Block block) {
        super(block);
        this.blockPrevious = null;
    }
    public BlockUpdateEvent(Block block, Block blockPrevious) {
        super(block);
        this.blockPrevious = blockPrevious;
    }
    public Block getPrevious(){
        return this.blockPrevious;
    }

}
