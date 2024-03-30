package satisfy.farmcharm.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import satisfy.farmcharm.registry.BlockEntityTypeRegistry;

public class ScarecrowBlockEntity extends BlockEntity {
    private long lastTickTime = 0;

    public ScarecrowBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityTypeRegistry.SCARECROW.get(), pos, state);
    }

    public void tick() {
        if (this.level instanceof ServerLevel serverLevel && !this.level.isClientSide) {
            long currentTime = serverLevel.getGameTime();
            long bonemealInterval = 20 * 25;
            if (currentTime - lastTickTime > bonemealInterval) {
                lastTickTime = currentTime;
                applyBonemealEffect(serverLevel);
            }
        }
    }

    private void applyBonemealEffect(ServerLevel serverLevel) {
        BlockPos.betweenClosedStream(this.getBlockPos().offset(-8, -1, -8), this.getBlockPos().offset(8, 1, 8))
                .forEach(pos -> {
                    BlockState blockState = serverLevel.getBlockState(pos);
                    if (blockState.getBlock() instanceof CropBlock cropBlock && !cropBlock.isMaxAge(blockState)) {
                        cropBlock.randomTick(blockState, serverLevel, pos, serverLevel.random);
                        serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
                    }
                });
    }
}
