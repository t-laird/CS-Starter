package com.campspot;

import com.campspot.Service.CampsiteService;
import com.campspot.Service.ReservationService;
import com.campspot.resources.CampsitesResource;
import com.campspot.resources.ReservationResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.campspot.resources.HelloWorldResource;
import com.campspot.health.TemplateHealthCheck;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);
    private static final String SQL = "sql";
    private static final String DROPWIZARD_MYSQL_SERVICE = "Dropwizard MySQL Service";

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }


    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        DBI dbi = new DBI(dataSource);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(new CampsitesResource(dbi.onDemand(CampsiteService.class)));
        environment.jersey().register(new ReservationResource(dbi.onDemand(ReservationService.class)));
    }
}
