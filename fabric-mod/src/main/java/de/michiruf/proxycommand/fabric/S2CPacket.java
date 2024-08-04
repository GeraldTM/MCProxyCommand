package de.michiruf.proxycommand.fabric;

import de.michiruf.proxycommand.common.ProxyCommandConstants;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class S2CPacket {

  public record ProxyCommandPacket(String command) implements CustomPayload {
    public static final CustomPayload.Id<ProxyCommandPacket> PACKET_ID = new CustomPayload.Id<>(
      Identifier.of(ProxyCommandConstants.COMMAND_PACKET_ID)
    );
    public static final PacketCodec<PacketByteBuf, ProxyCommandPacket> PACKET_CODEC = PacketCodec.of(
      (value, buf) -> buf.writeString(value.command),
      buf -> new ProxyCommandPacket(buf.readString())
    );
    @Override
    public Id<? extends CustomPayload> getId() {
      return PACKET_ID;
    }
  }

  public S2CPacket() {
    PayloadTypeRegistry
      .playS2C()
      .register(ProxyCommandPacket.PACKET_ID, ProxyCommandPacket.PACKET_CODEC);
  }

  public void sendCommandPacket(ServerPlayerEntity player, String command) {
    ServerPlayNetworking.send(player, new ProxyCommandPacket(command));
  }
}
