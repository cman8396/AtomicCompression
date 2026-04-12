package com.mcnair.atomic.utility;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AtomicVoxelHelper {

    public static final VoxelShape FULL_BLOCK = Block.box(0D, 0D, 0D, 16D, 16D, 16D);

    public static final VoxelShape CONNECTOR_NORTH = Block.box(4D, 4D, 0D, 12D, 12D, 16D);
    public static final VoxelShape CONNECTOR_SOUTH = Block.box(4D, 4D, 0D, 12D, 12D, 16D);
    public static final VoxelShape CONNECTOR_EAST = Block.box(0D, 4D, 4D, 16D, 12D, 12D);
    public static final VoxelShape CONNECTOR_WEST = Block.box(0D, 4D, 4D, 16D, 12D, 12D);
    public static final VoxelShape CONNECTOR_NONE = Block.box(0D, 0D, 0D, 16D, 16D, 16D);

    public static final VoxelShape INJECTOR_PORT_NORTH = Block.box(4D, 4D, 0D, 12D, 12D, 1D);
    public static final VoxelShape INJECTOR_PORT_SOUTH = Block.box(4D, 4D, 15D, 12D, 12D, 16D);
    public static final VoxelShape INJECTOR_PORT_EAST = Block.box(0D, 4D, 4D, 1D, 12D, 12D);
    public static final VoxelShape INJECTOR_PORT_WEST = Block.box(15D, 4D, 4D, 16D, 12D, 12D);
    public static final VoxelShape INJECTOR_BASE = Block.box(1D, 0D, 1D, 15D, 14D, 15D);


    // Courtesy of "henkelmax/corelib" ... https://github.com/henkelmax/corelib/tree/master
    public static VoxelShape combine(VoxelShape... shapes) {
        if (shapes.length <= 0) {
            return Shapes.empty();
        }
        VoxelShape combined = shapes[0];

        for (int i = 1; i < shapes.length; i++) {
            combined = Shapes.or(combined, shapes[i]);
        }

        return combined;
    }
}
