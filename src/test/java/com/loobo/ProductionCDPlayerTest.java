package com.loobo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DevelopmentProfileConfig.class, ProductionProfileConfig.class})
@ActiveProfiles("production")
public class ProductionCDPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Before
    public void setUp() throws Exception {
        systemOutRule.enableLog();
    }

    @Autowired
    CDPlayer cdPlayer;

    @Test
    public void production_cd_player_should_be_used() throws Exception {
        cdPlayer.play();
        assertEquals(systemOutRule.getLog(), "production cd player.\n");
    }
}