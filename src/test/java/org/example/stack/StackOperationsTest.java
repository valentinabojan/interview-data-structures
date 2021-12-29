package org.example.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.stack.StackOperations.areBalancedParanthesis;

class StackOperationsTest {

    @Test
    public void areBalancedParanthesisTest() {
        assertThat(areBalancedParanthesis("{[()]}")).isTrue();
        assertThat(areBalancedParanthesis("{[(])}")).isFalse();
        assertThat(areBalancedParanthesis("{{[[(())]]}}")).isTrue();

        assertThat(areBalancedParanthesis("}][}}(}][))]")).isFalse();
        assertThat(areBalancedParanthesis("[](){()}")).isTrue();
        assertThat(areBalancedParanthesis("()")).isTrue();
        assertThat(areBalancedParanthesis("({}([][]))[]()")).isTrue();
        assertThat(areBalancedParanthesis("{)[](}]}]}))}(())(")).isFalse();
        assertThat(areBalancedParanthesis("([[)")).isFalse();
    }

}