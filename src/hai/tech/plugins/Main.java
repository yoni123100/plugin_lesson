package hai.tech.plugins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	//########################################################################
	//																פונקציה שתתבצע אחרי שהפלאגין נדלק בשרת
	//########################################################################
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin enabled!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	//########################################################################
	//																פונצקיה שתתבצע אחרי שהפלאגין נכבה בשרת
	//########################################################################
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin disabled!");
	}
	
	//########################################################################
	//																			פונקציה שתתבצע אחרי ששחקן נהרג
	//########################################################################
	@EventHandler
	public void onWhenPlayerDies(PlayerDeathEvent event) {
		Player player = (Player) event.getEntity();
		player.sendMessage("Shalom again!");
	}
	
	//########################################################################
	//																				פונקציה שתתבצע אחרי שחץ יפול
	//########################################################################
	@EventHandler
	public void onWhenArrowFalls(ProjectileHitEvent event) {
		if(!(event.getEntity() instanceof Arrow)) return;
		Arrow arrow = (Arrow) event.getEntity();
	}
	
	//########################################################################
	//																			פונקציה שתתבצע אחרי שבלוק נשבר
	//########################################################################
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = (Player) event.getPlayer();
		player.sendMessage(ChatColor.YELLOW  + "You broke " + event.getBlock().getType().name()); //שולח איזה בלוק שברתם
	}
	
	//########################################################################
	//																			פונקציה שתתבצע אחרי ששחקן ישלח הודעה בצאט
	//########################################################################
	@EventHandler
	public void playerSendsChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
	}
	
	//########################################################################
	//																	פונקציה שתתבצע אחרי ששחקן עושה איזשהי פעולה
	//																				כגוון: לחיצה ימנית או שמאלית על העכבר
	//########################################################################
	@EventHandler
	public void playerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
	}
	
	//########################################################################
	//																			פונקציה שתתבצע אחרי ששחקן נכנס לשרת שלנו
	//########################################################################
	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.AQUA + "Shalom player " + player.getName());
	}
	
	//########################################################################
	//																			פונקציה שתתבצע אחרי ששחקן יוצא מהשרת שלנו
	//########################################################################
	@EventHandler
	public void playerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
	}
	
	//########################################################################
	//																							פונקצית הפקודה
	//																						כאן אנו יוצרים את הפקודה
	//########################################################################
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		if(tag.equalsIgnoreCase("shalom")) {
			sender.sendMessage(ChatColor.BLUE + "Shalom, " + sender.getName()); //שולח הודעת שלום לכותב הפקודה
			sender.sendMessage(ChatColor.DARK_RED + "How are you?");
			return true;
		}
		return false;
	}

}
