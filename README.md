## Spring boot features samples

This is a self explanatory repository. Visit each class and read comment section for more information about features in contains.


##### Property relax binding (key contains dot)

When a key contains dot in name usually spring considers it as nested member where as some cases same not applied. For example in case of mail configuration, keys are some what like below

> 
    email_config.mail.smtp.host=smtp.gmail.com
    email_config.mail.smtp.socketFactory.port=465
    email_config.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
    email_config.mail.smtp.auth=true
    email_config.mail.smtp.port=465

So when we try to use `@ConfigurationProperties` with above key value pairs we get following nested member structure

>
	mail
		smtp
			host=smtp.gmail.com
			socketFactory.port=465
			socketFactory.class=javax.net.ssl.SSLSocketFactory
			auth=true
			port=465

If we need to consider dots as part of key then do modify properties as below.

> 
    email_config.[mail.smtp.host]=smtp.gmail.com
    email_config.[mail.smtp.socketFactory.port]=465
    email_config.[mail.smtp.socketFactory.class]=javax.net.ssl.SSLSocketFactory
    email_config.[mail.smtp.auth]=true
    email_config.[mail.smtp.port]=465

>
	@Bean
	@ConfigurationProperties(prefix = "email_config")
	public Properties emailConfig() {
		return new Properties();
	}