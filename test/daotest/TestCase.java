package daotest;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.mapper.ItemsMapperCustom;
import com.ssm.po.ItemsCustom;
import com.ssm.service.ItemsService;

public class TestCase {
	@Test
	public void test1() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/*.xml");
		ItemsMapperCustom bean = ac.getBean("itemsMapperCustom",ItemsMapperCustom.class);
		List<ItemsCustom> list = bean.findItemsList(null);
		System.out.println(list);
	}
	@Test
	public void test2() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/*.xml");
		ItemsService bean = ac.getBean("itemsService",ItemsService.class);
		List<ItemsCustom> list = bean.findItemsList(null);
		System.out.println(list);
	}
}
