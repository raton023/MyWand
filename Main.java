package com.craftilandia.mywand;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener {
	
	
	 public static Main plugin;
	  
	 public void onEnable(){
	 this.getServer().getPluginManager().registerEvents(this, this);
	 }
	  
	 

	 
	 int encanto = 0;
	 @SuppressWarnings("deprecation")
	@EventHandler
	 public void onPlayerInteract(final PlayerInteractEvent e){
	 Player p = e.getPlayer();
	 if((p.getItemInHand() != null) && (p.getItemInHand().getType() == Material.BLAZE_ROD)){
		 if((e.getItem().getItemMeta().getDisplayName() != null) && e.getItem().getItemMeta().getDisplayName().endsWith("Wand")){
	 if((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
		 if(encanto <= 8){
			 encanto++;
			 if(encanto == 1){
					p.sendMessage("[ My Wand ] 01 Thunder"); 
			 }else if(encanto == 2){
					p.sendMessage("[ My Wand ] 02 TP TP"); 
			 }else if(encanto == 3){
					p.sendMessage("[ My Wand ] 03 TNT"); 
			 }else if(encanto == 4){
					p.sendMessage("[ My Wand ] 04 FLY"); 
			 }else if(encanto == 5){
					p.sendMessage("[ My Wand ] 05 Disarm"); 
			 }else if(encanto == 6){
					p.sendMessage("[ My Wand ] 06 Move It"); 
			 }else if(encanto == 7){
					p.sendMessage("[ My Wand ] 07 Capture"); 
			 }else if(encanto == 8){
					p.sendMessage("[ My Wand ] 01 Thunder");
					encanto=1;
			 }
	 }
	 }
	 if((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)){
	 if(encanto == 1){
	Location loc = p.getTargetBlock(null, 80).getLocation();
	 p.getWorld().strikeLightning(loc);
	 p.getWorld().playEffect(p.getLocation(), org.bukkit.Effect.EXTINGUISH, 1);
	 
	 }else if(encanto == 2){
		 for(Entity mob : p.getNearbyEntities(10.0D, 10.0D, 10.0D)){
			 Location loc1 = mob.getLocation();
			 Location loc2 = p.getLocation();
			 p.teleport(loc1);
			 mob.teleport(loc2);
		 }
	  
	  
	 }else if(encanto == 3){
	Location loc = p.getTargetBlock(null, 80).getLocation();
	 p.getWorld().createExplosion(loc, 2); // el 2 es explocion baja 10 seria grande

	  
	 }else if(encanto == 4){
		 
         Vector v = e.getPlayer().getLocation().getDirection();
         p.setVelocity(v.multiply(2));

	 }else if(encanto == 5){
for(Entity mobdis : p.getNearbyEntities(10.0D, 10.0D, 10.0D)){
	if(mobdis instanceof Zombie){
		((Zombie) mobdis).getEquipment().getItemInHand().setType(Material.AIR);
	    ((LivingEntity) mobdis).getEquipment().setItemInHand(null);

	}
	if(mobdis instanceof Skeleton){
		((Skeleton) mobdis).getEquipment().getItemInHand().setType(Material.AIR);
	    ((LivingEntity) mobdis).getEquipment().setItemInHand(null);

	}
	if(mobdis instanceof Player){
		((Player) mobdis).getEquipment().getItemInHand().setType(Material.AIR);
	    ((LivingEntity) mobdis).getEquipment().setItemInHand(null);
	    
	   



	}
}}
	
	 else if(encanto == 6){

		    {
		    	for(Entity mob1 : p.getNearbyEntities(10.0D, 10.0D, 10.0D))
		    	{
		        Location loc3 = mob1.getLocation();
				 p.getWorld().playEffect(loc3, org.bukkit.Effect.ENDER_SIGNAL, 4, 10);
		    	}
				 Bukkit.getScheduler().runTaskLater(this, new Runnable() {
		             public void run(){
		     			for(Entity mob : e.getPlayer().getNearbyEntities(10.0D, 10.0D, 10.0D))
		     			{
		     				//Location loc2 = mob.getLocation();//Get the location from the target player
		     				Location locp = e.getPlayer().getLocation();
		     				Location locm = mob.getLocation();
if(mob instanceof Creature && !(mob instanceof Monster)){
	  Vector vector = locp.toVector().subtract(locm.toVector()); //atrae a uno
	  mob.setVelocity(vector.multiply(0.15).setY(0.6));
}
		     				  
		     				  if(mob instanceof Monster){
		     					 Vector vec = new Vector(0.0D, 2.0D, 0.0D);
		     				    mob.setVelocity(vec);
}
if(mob instanceof Item){
	  Vector vector = locp.toVector().subtract(locm.toVector()); //atrae a uno
	  mob.setVelocity(vector.multiply(0.05).setY(0.6));

}
		     			}
		             }
		           },23L);
		    
	}

		}else if(encanto == 7){
		    {
		    	 for(Entity mob : p.getNearbyEntities(10.0D, 10.0D, 10.0D))
		    	 {
		    		 if(mob instanceof Creature || mob instanceof Player){
				    	 
		    			   final Block loc1 = mob.getLocation().getBlock().getRelative(BlockFace.EAST);
		    			   final Block loc2 = mob.getLocation().getBlock().getRelative(BlockFace.WEST);
		    			   final Block loc3 = mob.getLocation().getBlock().getRelative(BlockFace.NORTH);
		    			   final Block loc4 = mob.getLocation().getBlock().getRelative(BlockFace.SOUTH);
		    			   final Block loc5 = mob.getLocation().getBlock().getRelative(BlockFace.NORTH_EAST);
		    			   final Block loc6 = mob.getLocation().getBlock().getRelative(BlockFace.NORTH_WEST);
		    			   final Block loc7 = mob.getLocation().getBlock().getRelative(BlockFace.SOUTH_EAST);
		    			   final Block loc8 = mob.getLocation().getBlock().getRelative(BlockFace.SOUTH_WEST);
		    			   loc1.setType(Material.NETHER_FENCE);
		    			   loc2.setType(Material.NETHER_FENCE);
		    			   loc3.setType(Material.NETHER_FENCE);
		    			   loc4.setType(Material.NETHER_FENCE);
		    			   loc5.setType(Material.NETHER_FENCE);
		    			   loc6.setType(Material.NETHER_FENCE);
		    			   loc7.setType(Material.NETHER_FENCE);
		    			   loc8.setType(Material.NETHER_FENCE);
		    			   
		    	           Bukkit.getScheduler().runTaskLater(this, new Runnable() {
		    		             public void run(){
			    		               loc1.setType(Material.AIR);
			    		               loc2.setType(Material.AIR);
			    		               loc3.setType(Material.AIR);
			    		               loc4.setType(Material.AIR);
			    		               loc5.setType(Material.AIR);
			    		               loc6.setType(Material.AIR);
			    		               loc7.setType(Material.AIR);
			    		               loc8.setType(Material.AIR);
		    		             }
		    		           },160L);//20L es igual a un segundo
		    			   
		    			    		 }
		    	 }
	}

		}
}}}}


	 public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		 if (commandLabel.equalsIgnoreCase("wand")) {
		 Player player = (Player)sender;
		 ItemStack wand = new ItemStack(org.bukkit.Material.BLAZE_ROD);
		 ItemMeta im = wand.getItemMeta();
		 im.setDisplayName(org.bukkit.ChatColor.RED + "Magical_Wand");
		 //wand.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		 wand.setItemMeta(im);
		 PlayerInventory pi = player.getInventory();
		 pi.addItem(new ItemStack[] { wand });
		 }
		 return false;
		 }
 
	  
	 }
