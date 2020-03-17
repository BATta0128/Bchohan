package red.man10.batta.bchohan;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


import java.text.NumberFormat;
import java.util.Random;

public final class Bchohan extends JavaPlugin {
    int argsint = 0;
    double playerbal = 0;
    Random r = new Random();
    VaultManager vault = new VaultManager(this);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandSender p = sender;
        Player player = (Player)sender;
        int val = 0;
        //引数なしの時のコマンド説明
        if(args.length == 0){

            p.sendMessage("§b/bchohan c [金額] §6丁に[金額]円賭ける");
            p.sendMessage("§b/bchohan h [金額] §6半に[金額]円賭ける");
            return false;
        }
        //引数の数が間違っていた時の処理
        if (args.length != 2) {
            p.sendMessage("§4引数が違うよ /bchohan");
            return false;
        }
        //引数正常時動作
        if(args[0].equalsIgnoreCase("h")) {
            //掛け金が数字かつ1以上であるかの確認
            if (isNumber(args[1], p)){
                p.sendMessage("§bあなたは半に" + argsint + "円を賭けました。" );
                playerbal = new VaultManager(this).getBalance(player.getUniqueId());
                //所持金が足りているかの確認
                if(checkmoney(playerbal, argsint, p)){
                    //お金を引く処理
                    vault.withdraw(player.getUniqueId(), argsint);
                    //乱数を出して結果表示する処理
                    int randomValue = r.nextInt(2);
                    p.sendMessage("rの値は" + randomValue +"です");
                    if (randomValue == 0){
                        p.sendMessage("§b§lYou Win!!あなたの勝ち。" + argsint*2 +"円をゲット!");
                        vault.deposit(player.getUniqueId(), argsint*2);
                    }else{
                        p.sendMessage("§4§lYou Lose!!あなたの負け。" + argsint +"円をロスト!");
                    }

                }else{
                    return false;
                }

            }else{

                return false;
            }

        }
        if(args[0].equalsIgnoreCase("c")) {
            //掛け金が数字かつ1以上であるかの確認
            if (isNumber(args[1], p)){
                p.sendMessage("§bあなたは丁に" + argsint + "円を賭けました。" );
                playerbal = new VaultManager(this).getBalance(player.getUniqueId());
                //所持金が足りているかの確認
                if(checkmoney(playerbal, argsint, p)){
                    //お金を引く処理
                    vault.withdraw(player.getUniqueId(), argsint);
                    //乱数を出して結果表示する処理
                    int randomValue = r.nextInt(2);
                    p.sendMessage("rの値は" + randomValue +"です");
                    if (randomValue == 0){
                        p.sendMessage("§b§lYou Win!!あなたの勝ち。" + argsint*2 +"円をゲット!");
                        vault.deposit(player.getUniqueId(), argsint*2);
                    }else{
                        p.sendMessage("§4§lYou Lose!!あなたの負け。" + argsint +"円をロスト!");
                    }

                }else{
                    return false;
                }

            }else{

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

    //金額の数字確認と型の変更処理
    public boolean  isNumber(String num, CommandSender p){
        int num2 = 0;
        try{
            num2 = Integer.parseInt(num);
            argsint = num2;
            p.sendMessage("引数が数字であることを確認しました");
            if (argsint >= 1){
                return true;
            }else {
                p.sendMessage("§4賭け金は1円以上の整数で入力してください。");
                return false;
            }
        } catch(NumberFormatException e){
            p.sendMessage("§4賭け金は1円以上の整数で入力してください。");
            return false;
        }

    }

    //所持金が足りているかの確認処理
    public boolean checkmoney(double playerbal, int argsint, CommandSender p){
        if (playerbal >= argsint){
            p.sendMessage("お金が足りてます。");
            return true;
        }else {
            p.sendMessage("§4お金が足りません。");
            return false;
        }
    }

}
