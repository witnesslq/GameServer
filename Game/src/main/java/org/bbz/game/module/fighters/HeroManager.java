package org.bbz.game.module.fighters;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.ToString;
import org.bbz.game.ClientException;
import org.bbz.game.ErrorCode;
import org.bbz.game.cfg.fighter.FighterTemplet;
import org.bbz.game.cfg.fighter.FighterTempletCfg;
import org.bbz.game.module.equipments.Equipment;
import org.bbz.util.common.RandomUtil;

import java.util.List;
import java.util.Set;

/**
 * user         LIUKUN
 * time         14-3-25 下午1:52
 * 英雄管理类
 */

@Data
@ToString
public class HeroManager{

    private final HeroDataProvider db;

    /**
     * 所有的英雄
     */
    private List<Hero> heros;

    public HeroManager( String uname ){
        db = new HeroDataProvider( uname );
        heros = db.getAll();
    }

    /**
     * 英雄升级
     *
     * @param heroId 要升级的英雄
     */
    public void levelUp( int heroId ){
        Hero hero = getHeroById( heroId );
        if( hero == null ) {
            throw new ClientException( ErrorCode.HERO_NOT_FOUND, heroId + "不存在" );
        }
        hero.levelUp();
    }

    private Hero getHeroById( int heroId ){
        for( Hero hero : heros ) {
            if( hero.getId() == heroId ) {
                return hero;
            }
        }
        return null;
    }

    private void test(){
        for( int i = 0; i < 100; i++ ) {


            Hero hero = new Hero( i );
            hero.setPosition( i * 1000000 );
            hero.setName( "abcd" );
            hero.setExp( RandomUtil.getInt( 1909090 ) );
            Set<Equipment> equipments = Sets.newHashSet();

            for( int j = 0; j < 5; j++ ) {
                Equipment e = new Equipment();
                e.setId( j );
                equipments.add( e );
            }
            hero.setEquipments( equipments );
            int templetId = 100001 + RandomUtil.getInt( 80 );
            FighterTemplet templet = FighterTempletCfg.getFighterTempletById( templetId );
            hero.setTemplet( templet );
            db.add( hero );
        }
    }

    public static void main( String[] args ){
        HeroManager manager = new HeroManager( "lk" );

        manager.db.getCollection().drop();
        System.out.println( manager.db.getCollection().count() );
        manager.test();
        System.out.println( manager.db.getCollection().count() );
        System.out.println( manager.getHeroById( 5 ) );
        System.out.println( manager.getHeroById( 50 ) );

        Hero hero = manager.getHeroById( 50 );
        hero.setExp( 539432 );
        manager.db.update( hero );
        System.out.println( manager.getHeroById( 50 ) );
        System.out.printf( "level:" + hero.getLevel() );

//        System.out.println( "开始写入一百万条数据........" );
//        long begin = System.nanoTime();
//        for( int i = 0; i < 1; i++ ) {
//            manager.test();
//
//        }
//        System.out.println( "完成写入一亿条数据........" );
//        System.out.println( "写入操作耗时：" + (System.nanoTime() - begin) / 1000000000f + "秒" );
//
//
////        test.test();
//        begin = System.nanoTime();
//        for( int i = 0; i < 500; i++ ) {
//            int index = RandomUtil.getInt( 1000000 );
//            DBObject condition = new BasicDBObject( "_id", index );
//            Hero hero = manager.db.findOne( condition );
//
//            System.out.println( hero.getId() + ":" + hero.getPosition() + ":" + (hero.getId() * 100 == hero.getPosition()) );
//        }
//        System.out.println( "查找操作耗时：" + (System.nanoTime() - begin) / 1000000000f + "秒" );

    }


}
