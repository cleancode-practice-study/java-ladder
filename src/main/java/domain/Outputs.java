package domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getOutputNames() {
        return outputs
                .stream()
                .map(Output::getOutputName)
                .collect(Collectors.toList());
    }
}
