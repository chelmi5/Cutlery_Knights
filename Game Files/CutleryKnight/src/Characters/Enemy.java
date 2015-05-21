package Characters;

import Objects.Stats;

public abstract class Enemy{

   public   String   enemyName;
   private Stats stats;
   private  int      damageRangeMin;
   private  int      damageRangeMax;
   private  double   percentToDefend;
   
   public Enemy(String enemyName, int DMin, int DMax, double percentToDefend){
      this.damageRangeMin  = DMin;
      this.damageRangeMax  = DMax;
      this.enemyName       = enemyName;
      this.percentToDefend = percentToDefend;
   }
   
   public int attack(){
      int actualDamage = determineDamage();
      return actualDamage;
   }
   
   public boolean defend(int damage){
      
      if (percentToDefend < Math.random()){
         stats.updateHP(damage);
         return true;
      }
      return false;
   }

   private int determineDamage(){
      return (int)((Math.random()*(damageRangeMax - damageRangeMin)) + damageRangeMin);
   }

   protected void setDMin(int val){
      this.damageRangeMin = val;
   }

   protected void setDMax(int val){
      this.damageRangeMax = val;
   }

   protected void setPDefend(double val){
      this.percentToDefend = val;
   }

   protected void setEName(String val){
      this.enemyName = val;
   }
   
   public void setAllValues(String eName, int DMin, int DMax, double pToDefend){
      setDMin(DMin);
      setDMax(DMax);
      setPDefend(pToDefend);
      setEName(eName);
   }




}