package com.batch.annotations;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("PersonItemProcessor")
public class PersonItemProcessor implements ItemProcessor<PersonModelRead, PersonModelWrite> {

	public PersonModelWrite process(PersonModelRead person) throws Exception {
		int totalsalary= person.getSalary1()+person.getSalary2();
		System.out.println("person id:"+person.getId() +" person name:"+person.getName()+"totalsal:"+ totalsalary);
		PersonModelWrite personwrite = new PersonModelWrite(person.getId(), person.getName(), totalsalary);
	    return personwrite;
		
	}

}
