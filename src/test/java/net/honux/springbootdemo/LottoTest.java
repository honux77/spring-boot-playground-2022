package net.honux.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class LottoTest {

    @Test
    void generateRandom() {
        Lotto[] lottos = new Lotto[2];
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = Lotto.generateRandom();
        }
        log.info("1:{} 2:{}",lottos[0], lottos[1]);
        assertThat(lottos[0].sum()).isNotEqualTo(lottos[1].sum());

    }
}
