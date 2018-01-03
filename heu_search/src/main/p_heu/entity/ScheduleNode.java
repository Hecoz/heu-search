package p_heu.entity;

public class ScheduleNode extends Node {
    private String thread;

    public ScheduleNode(int id, String thread) {
        this.id = id;
        this.thread = thread;
    }

    public String getThread() {
        return this.thread;
    }

    @Override
    public boolean isIdentical(Node node) {
        return this.id == node.id && isSame(node);
    }

    @Override
    public boolean isSame(Node node) {
        if (node instanceof ScheduleNode) {
            ScheduleNode scheduleNode = (ScheduleNode)node;
            return this.thread.equals(scheduleNode.getThread());
        }
        return false;
    }

    @Override
    public String toString() {
        return "ScheduleNode[" + id + "," + thread + "]";
    }
}
