package org.bbz.game.cfg.corona;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模版配置
 * @author liukun
 * 2014-3-28 13:31:20
 */
public class CoronaBankTempletCfg {
	private static final Map<Integer,CoronaBankTemplet> coronaBankTemplets = new HashMap<Integer, CoronaBankTemplet>();


	static{
		init();

	}
	private static final String FILE = "./Game/src/main/resources/xml/corona/coronaBank.xml";



	private static void init(){

		SAXBuilder builder = new SAXBuilder();
		Document document;
		try {
			document = builder.build( FILE );
			Element root = document.getRootElement();
			List<?> list = root.getChildren( "CoronaBank" );

			for (Object o : list) {
				CoronaBankTemplet templet = new CoronaBankTemplet( (Element) o );
				CoronaBankTemplet temp = coronaBankTemplets.put( templet.getId(), templet );
				if( temp != null ){
					throw new RuntimeException( "CoronaBankTemplet id [" + temp.getId() + "] 重复了" );
				}

			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println( "CoronaBankTemplet xml配置文件解析完毕" );
	}


	/**
	 * 通过id获取CoronaBankTemplet的引用
	 * @param   templetId   id
	 * @return  返回一个引用
	 */
	public static CoronaBankTemplet getCoronaBankTempletById( int templetId ){
		return coronaBankTemplets.get( templetId );
	}

	/*自定义代码开始*//*自定义代码结束*/

	public static void main(String[] args) {

		int id = 1;
		System.out.println( getCoronaBankTempletById( id ) );
	}
}
