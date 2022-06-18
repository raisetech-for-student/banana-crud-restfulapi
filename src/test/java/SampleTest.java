import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SampleTest {

    @Test
    void 成功するテスト(){
        assertThat(1).isEqualTo(1);
    }

    @Test
    void 失敗するテスト(){
        assertThat(1).isEqualTo(2);
    }
}
