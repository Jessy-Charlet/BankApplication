package BankApplication.ms_configServer.config;

import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitConfig {

    @Bean
    public CredentialsProvider credentialsProvider() {
        return new UsernamePasswordCredentialsProvider("MY_USERNAME", "MY_PASSWORD");
    }

    @Bean
    public TransportConfigCallback transportConfigCallback(CredentialsProvider provider){
        return transport -> transport.setCredentialsProvider(provider);
    }
}
