package com.mcnair.atomic.utility;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AtomicVoxelHelper {

    public static final VoxelShape CONNECTOR_NORTH = Block.box(4D, 4D, 0D, 12D, 12D, 16D);
    public static final VoxelShape CONNECTOR_SOUTH = Block.box(4D, 4D, 0D, 12D, 12D, 16D);
    public static final VoxelShape CONNECTOR_EAST = Block.box(0D, 4D, 4D, 16D, 12D, 12D);
    public static final VoxelShape CONNECTOR_WEST = Block.box(0D, 4D, 4D, 16D, 12D, 12D);
    public static final VoxelShape CONNECTOR_NONE = Block.box(0D, 0D, 0D, 16D, 16D, 16D);

}
