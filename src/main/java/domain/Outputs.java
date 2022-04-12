package domain;

import java.util.List;

public class Outputs {
    final List<Output> outputs;

    public Outputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public int getOutputsCount() {
        return outputs.size();
    }
}
