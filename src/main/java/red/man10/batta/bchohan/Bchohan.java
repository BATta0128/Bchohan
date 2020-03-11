package red.man10.batta.bchohan;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
//import sun.java2d.xr.MutableInteger;

import java.text.NumberFormat;

public final class Bchohan extends JavaPlugin {
    int argsint = 0;
    double playerbal = 0;
    //VaultManager vault = new VaultManager(this);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandSender p = sender;
        Player player = (Player)sender;
        int val = 0;

        if(args.length == 0){

            p.sendMessage("§b/bchohan c [金額] --丁に[金額]円賭ける");
            p.sendMessage("§b/bchohan h [金額] --半に[金額]円賭ける");
            return false;
        }
        if (args.length != 2) {
            p.sendMessage("§4引数が違うよ /bchohan");
            return false;
        }

        if(args[0].equalsIgnoreCase("h")) {

            isNumber(args[1]);
            playerbal = new VaultManager(this).getBalance(player.getUniqueId());
            if (playerbal >= argsint ) {//次ここから
            }


           // tryParse(args[1]);
            p.sendMessage("§bあなたは半に" + args[1]+ "円を賭けました。" );
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

    //金額の数字確認と型の変更処理
    public boolean  isNumber(String num){
        int num2 = 0;
        try{
            num2 = Integer.parseInt(num);
            argsint = num2;
            return true;
        } catch(NumberFormatException e){
            return false;
        }

    }
/*
    public static boolean tryParse(String num, MutableInteger result){
        try{
            int i = Integer.parseInt(num);
            result.setValue(i);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }*/
}
