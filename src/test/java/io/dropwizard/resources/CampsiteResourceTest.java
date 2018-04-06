package io.dropwizard.resources;

import com.campspot.Service.CampsiteService;
import com.campspot.domain.Campsite;
import com.campspot.resources.CampsitesResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.eq;


public class CampsiteResourceTest {
    private static final CampsiteService campsiteService = mock(CampsiteService.class);
    private Campsite campsite;
    private ArrayList<Campsite> campsiteList = new ArrayList<Campsite>();

    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule.builder()
            .addResource(new CampsitesResource(campsiteService))
            .build();

    @Before
    public void setup() {
        this.campsite = new Campsite("Test Campsite");
        this.campsite.setId(1);


        this.campsiteList.add(new Campsite("Test Campsite"));
        this.campsiteList.add(new Campsite("Test Campsite 2"));


        Mockito.when(campsiteService.getCampsite(eq(1))).thenReturn(this.campsite);
        Mockito.when(campsiteService.getCampsites()).thenReturn(this.campsiteList);
    }

    @After
    public void tearDown() {
        reset(campsiteService);
    }

    @Test
    public void testGetCampsite() {
        Campsite res = RESOURCES.client().target("/campsites/1").request().get(Campsite.class);
        assertThat(res.getName())
                .isEqualTo(this.campsite.getName());
        assertThat(res.getId())
                .isEqualTo((this.campsite.getId()));
        verify(campsiteService).getCampsite(1);
    }

    @Ignore
    @Test
    public void testGetCampsites() {
        ArrayList<Campsite> res = RESOURCES.client().target("/campsites").request().get(ArrayList.class);
        System.out.println(res);
        assertThat(res.size())
                .isEqualTo(this.campsiteList.size());
    }




}
