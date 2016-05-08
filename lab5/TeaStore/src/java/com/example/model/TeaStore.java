/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fadyyounan
 */
public class TeaStore {
    
    public TeaStore(){
        buildStore();
    }
    
    protected List<TeaCategory> teaCategories = new ArrayList<TeaCategory>();
    
    private void buildStore(){
        TeaCategory green = new TeaCategory("GREEN TEAS",
                "Straight green teas have a clean, delicious taste you will enjoy. When paired with other fruits or spices, the flavor excites your tastebuds and provides a very healthy treat. Green teas include EGCG complex, a highly desirable antioxidant. ",
                "http://s7d5.scene7.com/is/image/Teavana/X01%2003%2002%2007_d?$feat$");
        green.addBrand(new TeaBrand("MATCHA JAPANESE GREEN TEA", 
                "Celebrated in the traditional Japanese tea ceremony 'chado' known as the 'Way of Tea' since the 12th Century, this highly shaded green tea uses the entire leaf delicately ground into a silky smooth chartreuse colored powder.", 
                "http://s7d5.scene7.com/is/image/Teavana/10004541000001_d?$snrl$", 
                19.95));
        green.addBrand(new TeaBrand("JASMINE DRAGON PHOENIX PEARLS GREEN TEA", 
                "Featuring the youngest of green tea leaves scented 6-8 times with summery blossoms of fresh jasmine, this tea is a phenomenon of fragrance and sweetness. Three leaves are hand rolled into pearls and slowly unfold the rich and smooth sweet floral flavor for a truly elegant delight. Experience the time-perfected trio of leaves releasing a subtle-sweet bouquet of seasonal jasmine.", 
                "http://s7d5.scene7.com/is/image/Teavana/X01%2006%2005%2001_d?$snrl$", 
                12.00));
        green.addBrand(new TeaBrand("BLACKBERRY MOJITO GREEN TEA", 
                "A passionate salsa dance where rhythm is the unspoken language, this refreshing green tea perfectly captures the Latin-inspired minty mojito cocktail. Combining succulent blackberries and raspberries with a spearmint kick, this Latin wonder is also excellent iced. ", 
                "http://s7d5.scene7.com/is/image/Teavana/20004780_d?$snrl$", 
                7.80));
        green.addBrand(new TeaBrand("SAKURA ALLURE GREEN TEA", 
                "Elegantly cut bamboo is the base of this enchanting green tea blend, enhancing the clean refreshing taste of cherry, pineapple, mango, rose and hibiscus. The Kyoto temple's Sakura blossoms in full bloom make the spiritual coupling of floral and fruit come alive as rose and hibiscus intertwine with lively cherry, mango and candied pineapple.", 
                "http://s7d5.scene7.com/is/image/Teavana/30464_d?$snrl$", 
                8.00));
        teaCategories.add(green);
        
        TeaCategory black = new TeaCategory("BLACK TEAS",
                "Delicious black teas are loved in the West. Full-bodied and strong, they taste great alone or with milk and sugar. And they make great iced tea. The caffeine makes them a good morning tea. But unlike coffee, you won't have the jitters. ",
                "http://s7d5.scene7.com/is/image/Teavana/X01%2001%2000%2009_d?$feat$");
        black.addBrand(new TeaBrand("WEIGHT TO GO! PU-ERH TEA", 
                "Enticing, tantalizing and truly energizing this rosy blush blend of pu-erh black and green oolong teas merge to create an intoxicating mix of sweet fruit with bright mint. Sweet strawberries and golden delicious apples swirl into peppermint and spearmint and create guilt-free, slimful beauty inside and out. ", 
                "http://s7d5.scene7.com/is/image/Teavana/10004451_d?$snrl$", 
                9.80));
        black.addBrand(new TeaBrand("EARL GREY CREME BLACK TEA", 
                "High tea is further elevated with tart bergamot orange tastefully tempered by creamy Madagascar vanilla then blended with the classic pomp of an Earl Grey black tea. A majestically smooth confection that is now available any time the senses desire. Sprinkled with sunny blue cornflowers, this full leaf wonder is divinely delicious with a silky sweet finish. Dairy Free. ", 
                "http://s7d5.scene7.com/is/image/Teavana/X01%2005%2004%2005_d?$snrl$", 
                5.20));
        black.addBrand(new TeaBrand("ENGLISH BREAKFAST", 
                "Capturing posh, purity and pageantry, this hidden treasure of royal lineage raises this most beloved morning black tea to new heights. Each sip unfolds to reveal the complexity of the high grown full leaves. Feel like royalty with this elegantly time-honored classic and add a majestic nod to every cup. ", 
                "http://s7d5.scene7.com/is/image/Teavana/X01%2001%2000%2010_d?$snrl$", 
                4.40));
        black.addBrand(new TeaBrand("BLACK DRAGON PEARLS BLACK TEA", 
                "Fashionably rare spring-harvested black tea pearls are as coveted as the legendary gems they were inspired by. Just as their bejeweled counterparts take years to become perfection, each tea pearl consists of thirty leaves and buds hand picked and immediately rolled before the leaves can dry. ", 
                "http://s7d5.scene7.com/is/image/Teavana/X01%2001%2000%2014_d?$snrl$", 
                15.00));
        teaCategories.add(black);
        
        TeaCategory oolong = new TeaCategory("OOLONG TEAS",
                "Oolong (also Wulong) teas are often referred to as Weight-Loss Teas because they can be a productive part of a complete weight loss plan.",
                "http://s7d5.scene7.com/is/image/Teavana/X01%2002%2001%2003_d?$feat$");
        oolong.addBrand(new TeaBrand("SLIMFUL CHOCOLATE DECADENCE OOLONG TEA", 
                "Drawing inspiration from a decadent warm Hawaiian chocolate cake, this oolong blend is a luxurious mix of robust cacao, creamy toasted coconut, and ginger spice that satisfies even the strongest sweet tooth. Pink rose petals add romantic icing to this guilt-free treat enticing you to reach for seconds. Have your tea and eat it too!", 
                "http://s7d5.scene7.com/is/image/Teavana/30463_d?$snrl$", 
                10.00));
        oolong.addBrand(new TeaBrand("MAHARAJA CHAI OOLONG TEA", 
                "Rich spices wafting together create the intoxicating taste of India. Alluring chai intensely mixes with royal splendor oolong tea creating taste bursts of cinnamon, ginger, clove and nutty cardamom. The famed 'Spice Route' is conjured up in every rich cup of this robust and most favored chai. ", 
                "http://s7d5.scene7.com/is/image/Teavana/20004788_d?$snrl$", 
                12.00));
        oolong.addBrand(new TeaBrand("JASMINE OOLONG TEA", 
                "Capturing posh, purity and pageantry, this hidden treasure of royal lineage raises this most beloved morning black tea to new heights. Each sip unfolds to reveal the complexity of the high grown full leaves. Feel like royalty with this elegantly time-honored classic and add a majestic nod to every cup. ", 
                "http://s7d5.scene7.com/is/image/Teavana/X01%2001%2000%2010_d?$snrl$", 
                12.50));
        oolong.addBrand(new TeaBrand("ANJOU PEAR-ADISE OOLONG TEA", 
                "Sink your teeth into a succulent ripe pear in this orchard of oolong delights. A journey into paradise with each sip as the nectarous balance of fruit and floral unfold. The heart song of juicy pear and softly zinging passion fruit melts gently into notes of lemon, papaya and enchantingly fragrant hibiscus to reveal each cup of pear-adise.", 
                "http://s7d5.scene7.com/is/image/Teavana/20004789_d?$snrl$", 
                9.00));
        teaCategories.add(oolong);
    }
    
    public TeaBrand findBrandByName(String name){
        for(TeaCategory category:teaCategories){
            TeaBrand brand = category.findBrandByName(name);
            if(brand !=null){
                return brand;
            }
        }
        return null;
    }
    
    public TeaCategory findCategory(String categoryName){
        for(TeaCategory c:teaCategories){
            if(c.getName().equals(categoryName)){
                return c;
            }
        }
        
        return null;
    }
    
    public List<TeaCategory> getCategories(){
        return teaCategories;
    }
    
    private List<Order> orders = new ArrayList<Order>();
    
    public void addOrder(TeaBrand brand, int quantity){
        orders.add(new Order(brand, quantity));
    }
    
    public List<Order> getOrders(){
        return orders;
    }
    
    public double getTotalPrice(){
        double total = 0;
        
        for(Order o:orders){
            total+=o.getTotalPrice();
        }
        return total;
    }
}
