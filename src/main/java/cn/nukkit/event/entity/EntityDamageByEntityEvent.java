package cn.nukkit.event.entity;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.item.Item;
import cn.nukkit.potion.Effect;

import java.util.Map;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class EntityDamageByEntityEvent extends EntityDamageEvent {

    private final Entity damager;

    private float knockBack;

    public EntityDamageByEntityEvent(Entity damager, Entity entity, DamageCause cause, float damage) {
        this(damager, entity, cause, damage, 0.3f);
    }

    public EntityDamageByEntityEvent(Entity damager, Entity entity, DamageCause cause, Map<DamageModifier, Float> modifiers) {
        this(damager, entity, cause, modifiers, 0.3f);
    }

    public EntityDamageByEntityEvent(Entity damager, Entity entity, DamageCause cause, float damage, float knockBack) {
        super(entity, cause, damage);
        this.damager = damager;
        this.addAttackerModifiers(damager);
        if(entity instanceof Player){
            Player p = (Player) entity;
            if(p.getInventory().getHelmet().getId() == Item.NETHERITE_HELMET){
                knockBack -= 0.03f;
            }
            if(p.getInventory().getChestplate().getId() == Item.NETHERITE_CHESTPLATE){
                knockBack -= 0.05f;
            }
            if(p.getInventory().getLeggings().getId() == Item.NETHERITE_LEGGINGS){
                knockBack -= 0.04f;
            }
            if(p.getInventory().getBoots().getId() == Item.NETHERITE_BOOTS){
                knockBack -= 0.03f;
            }
        }
        this.knockBack = knockBack;
    }

    public EntityDamageByEntityEvent(Entity damager, Entity entity, DamageCause cause, Map<DamageModifier, Float> modifiers, float knockBack) {
        super(entity, cause, modifiers);
        this.damager = damager;
        this.addAttackerModifiers(damager);
        if(entity instanceof Player){
            Player p = (Player) entity;
            if(p.getInventory().getHelmet().getId() == Item.NETHERITE_HELMET){
                knockBack -= 0.03f;
            }
            if(p.getInventory().getChestplate().getId() == Item.NETHERITE_CHESTPLATE){
                knockBack -= 0.05f;
            }
            if(p.getInventory().getLeggings().getId() == Item.NETHERITE_LEGGINGS){
                knockBack -= 0.04f;
            }
            if(p.getInventory().getBoots().getId() == Item.NETHERITE_BOOTS){
                knockBack -= 0.03f;
            }
        }
        this.knockBack = knockBack;
    }

    protected void addAttackerModifiers(Entity damager) {
        if (damager.hasEffect(Effect.STRENGTH)) {
            this.setDamage((float) (this.getDamage(DamageModifier.BASE) * 0.3 * (damager.getEffect(Effect.STRENGTH).getAmplifier() + 1)), DamageModifier.STRENGTH);
        }

        if (damager.hasEffect(Effect.WEAKNESS)) {
            this.setDamage(-(float) (this.getDamage(DamageModifier.BASE) * 0.2 * (damager.getEffect(Effect.WEAKNESS).getAmplifier() + 1)), DamageModifier.WEAKNESS);
        }
    }

    public Entity getDamager() {
        return damager;
    }

    public float getKnockBack() {
        return knockBack;
    }

    public void setKnockBack(float knockBack) {
        this.knockBack = knockBack;
    }
}
