package games.strategy.engine.chat;

import games.strategy.engine.message.IChannelSubscribor;
import games.strategy.net.INode;

/**
 * Chat messages occur on this channel
 * 
 * @author sgb
 */
public interface IChatChannel extends IChannelSubscribor
{
    //we get the sender from MessageContext
    public void chatOccured(ChatMessage message);
    public void meMessageOccured(ChatMessage message);
    public void slapOccured(String playerName);
    

    public void speakerAdded(INode node, long version);
    public void speakerRemoved(INode node, long version);    
}