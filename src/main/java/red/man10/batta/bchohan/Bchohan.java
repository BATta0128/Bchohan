package red.man10.batta.bchohan;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bchohan extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0){
            CommandSender p = sender;
            p.sendMessage("§b/bchohan c [金額] --丁に[金額]円賭ける");
            p.sendMessage("§b/bchohan h [金額] --半に[金額]円賭ける");
            return false;
        }
        if(args[0].equalsIgnoreCase("h")) {
            if (args.length != 2) {
                return false;
            }


        }

        return true;
    }
    public void onEnable() {
        getLogger().info("Bchohan起動!" );
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
