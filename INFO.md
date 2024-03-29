# Spring / Spring Boot

## Spring Context

* `DI/IoC` - паттерны проектирования, позволяют достичь гибкости при разработке приложений благодаря агрегированию со слабой связью.

* `Spring` - навешивает на приложение каркас, требующий `DI/IoC`.

* `ApplicationContext` - интерфейс, который описывает поведение контейнера бинов.

* `Бин` - компонент, который имеет id, класс, на основе которого он создается, параметры конструктора или геттеров/сеттеров.

* `ClassPathXmlApplicationContext` - реализация `ApplicationContext`, описывает контейнер бинов, который считывает определения бинов из xml-файла.

* Использование xml-файла удобно, потому что не нужно перекомпилировать код.

### Аннотации 

`@Autowired` - выполняет связывание бина на основе его типа.

`@Qualifier` - аннотация уточняет бин по его id при использовании `@Autowired`.

`@Bean` - аннотация фабричного метода, результатом работы которого является бин.

`@Component` - аннотация класса, экземпляр которого является бином.

`@Value` - считывает из properties-файла нужное свойство.

`Environment` - интерфейс, объект которого можно связать с файлом со свойствами.

### Способы конфигурации

Есть несколько способов конфигурации приложения с помощью Spring:

1. `xml-файл` - удобен тем, что можно полностью переконфигурировать приложение без перекомпиляции.

2. `xml-файл` + `@Autowired` - удобно тем же, что и xml, но можно не указывать связи явно.

3. `xml-файл + @Autowired + @Bean` - позволяет переложить логику создания бинов внутрь Java.

4. `xml-файл + @Autowired + @Bean + @Component` - удобно для ваших классов, зачем зря писать @Bean?

5. `Java Config` - `@Autowired + @Bean + @Component + file.properties` - параметры приложения в отдельном файле, минимизируем количество кода для связывания бинов.

* Для ваших классов - `@Component`.

* Для чужик классов (чтобы их погрузить в контейнер бинов) - `@Bean`.

### Hibernate

* Session - сессия для работы с БД
* SessionFactory - фабрика сессий
* Configuration - конфигурация Hibernate (там указываем все необходимые свойства)
* hbm.xml - файл маппинга класса в таблицу.

### JPA

* EntityManager - менеджер сущностей, стандарт для работы с ORM в Java. Все ORM-фреймворки обязаны реализовывать JPA, если хотят отвечать стандартам ORM.

* @Table, @Entity, @Id, @ManyToOne, @OneToMany, @GeneratedValue, @Column

### Spring Data Jpa

* HikariDataSource - DataSource, который реализует принцип ConnectionPool.

* LocalContainerEntityManagerFactoryBean - класс, который позволяет создавать объекты EntityManager для Spring Data Jpa (адаптирует Hibernate под Spring)

* HibernateJpaVendorAdapter - класс, который адаптирует Hibernate для Spring Data Jpa

* PlatformTransactionManager - менеджер транзакций, чтобы не писать их руками.

* Spring Data Jpa - позволяет создавать JPA-репозитории для того, чтобы не писать самому запросы.