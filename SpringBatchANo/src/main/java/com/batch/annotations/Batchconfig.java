package com.batch.annotations;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableBatchProcessing
public class Batchconfig {
	
	@Bean
	public ItemReader<PersonModelRead> reader()
	{
	  FlatFileItemReader<PersonModelRead> reader = new FlatFileItemReader<PersonModelRead>();
	  reader.setResource(new ClassPathResource("Peson-data.csv"));
	  reader.setLineMapper(new DefaultLineMapper<PersonModelRead>()
			  {{
		          setLineTokenizer(new DelimitedLineTokenizer()
		          {
		        	  {
		        	  setNames(new String[] {"id","name","salary1","salary2"});
		        	  }
		          });
		          setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonModelRead>()
		          {
		        	  {
		        		  setTargetType(PersonModelRead.class);
		        	  }
		          });
				  
			  }});
			  
			  return reader;
	}
	
	@Bean
	public ItemWriter<PersonModelWrite> writer(DataSource datasource)
	{
		JdbcBatchItemWriter<PersonModelWrite>  writer = new JdbcBatchItemWriter<PersonModelWrite>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PersonModelWrite>());
		writer.setSql("insert into salaryaccount (id,name,totalsalary) values(:id,:name,:totalsalary)");
		writer.setDataSource(datasource);
		return writer;
		
	}
	
	@SuppressWarnings("unchecked")
	@Bean
	public ItemProcessor<PersonModelRead,PersonModelWrite> processor()
	{
		return new PersonItemProcessor();
	}
	
	@Bean 
	public Job createsalary(JobBuilderFactory jobs, Step step)
	{
		return jobs.get("createsalary")
				.flow(step)
				.end()
				.build();
	}
	
	@Bean
	public Step step(StepBuilderFactory stepbuilder, ItemReader<PersonModelRead> reader,
			ItemWriter<PersonModelWrite> writer, ItemProcessor<PersonModelRead, PersonModelWrite> processor)
	{
		return   stepbuilder.get("step")
				.<PersonModelRead, PersonModelWrite> chunk(5)
				.reader(reader);
		        .processor(processor);
		        .writer(writer);
		        .build();
		
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/ash2");
	    dataSource.setUsername("root");
	    dataSource.setPassword("ashish");
	    return dataSource;
	}

}
