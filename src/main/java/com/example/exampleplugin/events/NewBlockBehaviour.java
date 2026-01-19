package com.example.exampleplugin.events;

import com.example.exampleplugin.ExamplePlugin;
import com.hypixel.hytale.protocol.MouseButtonType;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerMouseButtonEvent;

public class NewBlockBehaviour {

    public static void onHit(PlayerMouseButtonEvent event)
    {
        Player player = event.getPlayer();

        var item = event.getItemInHand().getBlockId();

        if(item.equals("newBlock")){
            if( event.getMouseButton().mouseButtonType == MouseButtonType.Left)
                player.sendMessage(Message.raw("Teste 123321"));
        } else {
            player.sendMessage(Message.raw("Nao deu."));
        }

    }

}
