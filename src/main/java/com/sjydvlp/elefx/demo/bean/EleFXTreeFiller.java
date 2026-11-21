package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.input.EleFXInput;
import com.sjydvlp.elefx.component.tree.EleFXTree;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * EleFXTreeFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTreeFiller {

    public static void fill(VBox vBox) {
//        vBox.getChildren().add(basicUsageTest());
//        vBox.getChildren().add(selectableTest());
//        vBox.getChildren().add(customLeafNodeTest());
//        vBox.getChildren().add(lazyLoadingMultipleTimesTest());
//        vBox.getChildren().add(disabledCheckboxTest());
//        vBox.getChildren().add(defaultCheckedAndExpandedTest());
//        vBox.getChildren().add(checkedNodesTest());
//        vBox.getChildren().add(customNodeContentTest());
        vBox.getChildren().add(customNodeLabelStyleTest());
//        vBox.getChildren().add(treeNodeFilteringTest());
//        vBox.getChildren().add(accordionTest());
//        vBox.getChildren().add(draggableTest());
        vBox.setSpacing(10);
    }

    private record BasicNodeData(String name, List<BasicNodeData> zones) {}

    private static EleFXTree<BasicNodeData> basicUsageTest() {
        var tree = new EleFXTree<BasicNodeData>();
        tree.setHighlightCurrent(false);
        tree.setMaxWidth(600);
        tree.setProps(Map.of("label", "name", "children", "zones"));
        tree.setOnNodeClick(item -> System.out.println(item.getValue().name()));

        var roots = new ArrayList<BasicNodeData>();
        for (int i = 1; i <= 3; i++) {
            var children = new ArrayList<BasicNodeData>();
            int childCount = i == 1 ? 1 : 2;
            for (int j = 1; j <= childCount; j++) {
                var leaf = new BasicNodeData("Level three " + i + "-" + j + "-1", List.of());
                children.add(new BasicNodeData("Level two " + i + "-" + j, List.of(leaf)));
            }
            roots.add(new BasicNodeData("Level one " + i, children));
        }
        tree.setData(roots);
        return tree;
    }


    private static EleFXTree<String> selectableTest() {
        var tree = new EleFXTree<String>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setOnCheckChange(node -> System.out.printf(
                "%s, checked=%s, indeterminate=%s%n",
                node.getValue(), tree.isChecked(node), tree.isHalfChecked(node)
        ));

        var count = new AtomicInteger(1);
        tree.setLoad((node, resolve, reject) -> {
            if (node.level() == 0) {
                resolve.accept(List.of("Root1", "Root2"));
                return;
            }
            if (node.level() > 3) {
                resolve.accept(List.of());
                return;
            }

            boolean hasChildren = switch (node.data()) {
                case "Root1" -> true;
                case "Root2" -> false;
                default -> ThreadLocalRandom.current().nextBoolean();
            };

            var delay = new PauseTransition(Duration.millis(500));
            delay.setOnFinished(event -> resolve.accept(hasChildren
                    ? List.of("zone" + count.getAndIncrement(), "zone" + count.getAndIncrement())
                    : List.of()));
            delay.play();
        });
        tree.setLazy(true);
        return tree;
    }

    private record LeafNodeData(String name, boolean leaf) {}

    private static EleFXTree<LeafNodeData> customLeafNodeTest() {
        var tree = new EleFXTree<LeafNodeData>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setProps(Map.of("label", "name", "isLeaf", "leaf"));
        tree.setLoad((node, resolve, reject) -> {
            if (node.level() == 0) {
                resolve.accept(List.of(new LeafNodeData("region", false)));
                return;
            }
            if (node.level() > 1) {
                resolve.accept(List.of());
                return;
            }

            var delay = new PauseTransition(Duration.millis(500));
            delay.setOnFinished(event -> resolve.accept(List.of(new LeafNodeData("leaf", true), new LeafNodeData("zone", false))));
            delay.play();
        });
        tree.setLazy(true);
        return tree;
    }

    private static EleFXTree<LeafNodeData> lazyLoadingMultipleTimesTest() {
        var tree = new EleFXTree<LeafNodeData>();
        tree.setMaxWidth(600);
        tree.setProps(Map.of("label", "name", "isLeaf", "leaf"));

        var attempts = new AtomicInteger();
        tree.setLoad((node, resolve, reject) -> {
            if (node.level() == 0) {
                resolve.accept(List.of(new LeafNodeData("region", false)));
                return;
            }

            int attempt = attempts.incrementAndGet();
            var delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(event -> {
                if (attempt <= 3) {
                    reject.run();
                    return;
                }
                resolve.accept(List.of(
                        new LeafNodeData("zone1", true),
                        new LeafNodeData("zone2", true),
                        new LeafNodeData("zone3", true)
                ));
            });
            delay.play();
        });
        tree.setLazy(true);
        return tree;
    }

    private record DisabledNodeData(
            int id,
            String label,
            boolean disabled,
            List<DisabledNodeData> children
    ) {}

    private static EleFXTree<DisabledNodeData> disabledCheckboxTest() {
        var tree = new EleFXTree<DisabledNodeData>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setProps(Map.of("children", "children", "label", "label"));
        tree.setDisabledPredicate(item -> item.getValue().disabled());

        tree.setData(List.of(
                new DisabledNodeData(1, "Level one 1", false, List.of(
                        new DisabledNodeData(3, "Level two 2-1", false, List.of(
                                new DisabledNodeData(4, "Level three 3-1-1", false, List.of()),
                                new DisabledNodeData(5, "Level three 3-1-2", true, List.of())
                        )),
                        new DisabledNodeData(2, "Level two 2-2", true, List.of(
                                new DisabledNodeData(6, "Level three 3-2-1", false, List.of()),
                                new DisabledNodeData(7, "Level three 3-2-2", true, List.of())
                        ))
                ))
        ));

        return tree;
    }

    private record DefaultStateNode(
            int id, String label, List<DefaultStateNode> children
    ) {
        DefaultStateNode(int id, String label) {
            this(id, label, List.of());
        }
    }

    private static EleFXTree<DefaultStateNode> defaultCheckedAndExpandedTest() {
        var tree = new EleFXTree<DefaultStateNode>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setNodeKey(DefaultStateNode::id);
        tree.setProps(Map.of("children", "children", "label", "label"));

        tree.setData(List.of(
                new DefaultStateNode(1, "Level one 1", List.of(
                        new DefaultStateNode(4, "Level two 1-1", List.of(
                                new DefaultStateNode(9, "Level three 1-1-1"),
                                new DefaultStateNode(10, "Level three 1-1-2")
                        ))
                )),
                new DefaultStateNode(2, "Level one 2", List.of(
                        new DefaultStateNode(5, "Level two 2-1"),
                        new DefaultStateNode(6, "Level two 2-2")
                )),
                new DefaultStateNode(3, "Level one 3", List.of(
                        new DefaultStateNode(7, "Level two 3-1"),
                        new DefaultStateNode(8, "Level two 3-2")
                ))
        ));

        tree.expandKeys(List.of(2, 3));
        tree.setCheckedKeys(List.of(5));
        return tree;
    }

    private record TreeData(int id, String label, List<TreeData> children) {
        TreeData(int id, String label) {
            this(id, label, List.of());
        }
    }

    private static VBox checkedNodesTest() {
        var tree = new EleFXTree<TreeData>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setHighlightCurrent(true);
        tree.setNodeKey(TreeData::id);
        tree.setProps(Map.of("children", "children", "label", "label"));

        tree.setData(List.of(
                new TreeData(1, "Level one 1", List.of(
                        new TreeData(4, "Level two 1-1", List.of(
                                new TreeData(9, "Level three 1-1-1"),
                                new TreeData(10, "Level three 1-1-2")
                        ))
                )),
                new TreeData(2, "Level one 2", List.of(
                        new TreeData(5, "Level two 2-1"),
                        new TreeData(6, "Level two 2-2")
                )),
                new TreeData(3, "Level one 3", List.of(
                        new TreeData(7, "Level two 3-1"),
                        new TreeData(8, "Level two 3-2")
                ))
        ));
        tree.expandAll();

        var getByNode = new EleFXButton("get by node");
        getByNode.setOnAction(event -> System.out.println(
                tree.getCheckedNodes(false, false).stream().map(TreeItem::getValue).toList()));

        var getByKey = new EleFXButton("get by key");
        getByKey.setOnAction(event -> System.out.println(tree.getCheckedKeys(false)));

        var setByNode = new EleFXButton("set by node");
        setByNode.setOnAction(event ->
                tree.setCheckedNodes(List.of(tree.getNode(5),  tree.getNode(9)), false));

        var setByKey = new EleFXButton("set by key");
        setByKey.setOnAction(event -> tree.setCheckedKeys(List.of(3), false));

        var reset = new EleFXButton("reset");
        reset.setOnAction(event -> tree.setCheckedKeys(List.of(), false));

        var buttons = new FlowPane(4, 4);
        buttons.getChildren().addAll(getByNode, getByKey, setByNode, setByKey, reset);

        return new VBox(8, tree, buttons);
    }

    private static EleFXTree<?> customNodeContentTest() {
        record NodeData(int id, String label, List<NodeData> children) {}

        var data = List.of(
                new NodeData(1, "Level one 1", List.of(
                        new NodeData(4, "Level two 1-1", List.of(
                                new NodeData(9, "Level three 1-1-1", List.of()),
                                new NodeData(10, "Level three 1-1-2", List.of())
                        ))
                )),
                new NodeData(2, "Level one 2", List.of(
                        new NodeData(5, "Level two 2-1", List.of()),
                        new NodeData(6, "Level two 2-2", List.of())
                )),
                new NodeData(3, "Level one 3", List.of(
                        new NodeData(7, "Level two 3-1", List.of()),
                        new NodeData(8, "Level two 3-2", List.of())
                ))
        );

        var tree = new EleFXTree<NodeData>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setExpandOnClickNode(false);
        tree.setNodeKey(NodeData::id);
        tree.setProps(Map.of("label", "label", "children", "children"));

        var nextId = new AtomicInteger(1000);
        tree.setNodeGraphicFactory(item -> {
            var append = new EleFXButton("Append", EleFXButtonType.PRIMARY);
            append.setLink(true);
            append.setOnAction(event -> {
                var child = new NodeData(nextId.getAndIncrement(), "testtest", List.of());
                item.getChildren().add(new TreeItem<>(child));
                item.setExpanded(true);
            });

            var delete = new EleFXButton("Delete", EleFXButtonType.DANGER);
            delete.setLink(true);
            delete.setOnAction(event -> item.getParent().getChildren().remove(item));

            var label = new Label(item.getValue().label());
            label.setStyle("-fx-font-size: 14px;");
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            var actions = new HBox(4, append, delete);
            actions.setAlignment(Pos.CENTER_RIGHT);

            var row = new HBox(label, actions);
            row.setAlignment(Pos.CENTER_LEFT);
            row.setPadding(new Insets(0, 8, 0, 0));
            HBox.setHgrow(row, Priority.ALWAYS);
            return row;
        });

        tree.setData(data);
        tree.expandAll();
        return tree;
    }

    private static EleFXTree<?> customNodeLabelStyleTest() {
        record NodeData(int id, String label, boolean isPenultimate, List<NodeData> children) {
            NodeData(int id, String label) {
                this(id, label, false, List.of());
            }
        }

        var tree = new EleFXTree<NodeData>();
        tree.setMaxWidth(600);
        tree.setShowCheckbox(true);
        tree.setExpandOnClickNode(false);
        tree.setNodeKey(NodeData::id);
        tree.setProps(Map.of("label", "label", "children", "children"));
        tree.setLabelStyleIf("-fx-text-fill: #626aef;", NodeData::isPenultimate);
        tree.setData(List.of(
                new NodeData(1, "Level one 1", false, List.of(
                        new NodeData(4, "Level two 1-1", true, List.of(
                                new NodeData(9, "Level three 1-1-1"),
                                new NodeData(10, "Level three 1-1-2")
                        ))
                )),
                new NodeData(2, "Level one 2", true, List.of(
                        new NodeData(5, "Level two 2-1"),
                        new NodeData(6, "Level two 2-2")
                )),
                new NodeData(3, "Level one 3", true, List.of(
                        new NodeData(7, "Level two 3-1"),
                        new NodeData(8, "Level two 3-2")
                ))
        ));
        tree.expandAll();
        return tree;
    }


    private static VBox treeNodeFilteringTest() {
        var input = new EleFXInput();
        input.setPlaceholder("Filter keyword");
        input.setMaxWidth(240);

        var tree = new EleFXTree<TreeData>();
        tree.setMaxWidth(600);
        tree.setProps(Map.of("label", "label", "children", "children"));
        tree.setData(List.of(
                new TreeData(1, "Level one 1", List.of(
                        new TreeData(4, "Level two 1-1", List.of(
                                new TreeData(9, "Level three 1-1-1"),
                                new TreeData(10, "Level three 1-1-2")
                        ))
                )),
                new TreeData(2, "Level one 2", List.of(
                        new TreeData(5, "Level two 2-1"),
                        new TreeData(6, "Level two 2-2")
                )),
                new TreeData(3, "Level one 3", List.of(
                        new TreeData(7, "Level two 3-1"),
                        new TreeData(8, "Level two 3-2")
                ))
        ));
        tree.expandAll();

        input.textProperty().addListener((obs, oldText, keyword) -> {
            if (keyword == null || keyword.isEmpty()) {
                tree.filter(null);
            } else {
                tree.filter(node -> node.label().contains(keyword));
            }
        });

        return new VBox(8, input, tree);
    }

    private static EleFXTree<BasicNodeData> accordionTest() {
        var tree = basicUsageTest();
        tree.setAccordion(true);
        tree.setOnNodeClick(item -> System.out.println(item.getValue()));
        return tree;
    }

    private static EleFXTree<?> draggableTest() {
        record NodeData(int id, String label, List<NodeData> children) {
            NodeData(int id, String label, NodeData... children) {
                this(id, label, List.of(children));
            }
        }

        var data = List.of(
                new NodeData(1, "Level one 1",
                        new NodeData(2, "Level two 1-1",
                                new NodeData(3, "Level three 1-1-1"))),
                new NodeData(4, "Level one 2",
                        new NodeData(5, "Level two 2-1",
                                new NodeData(6, "Level three 2-1-1")),
                        new NodeData(7, "Level two 2-2",
                                new NodeData(8, "Level three 2-2-1"))),
                new NodeData(9, "Level one 3",
                        new NodeData(10, "Level two 3-1",
                                new NodeData(11, "Level three 3-1-1")),
                        new NodeData(12, "Level two 3-2",
                                new NodeData(13, "Level three 3-2-1")))
        );

        var tree = new EleFXTree<NodeData>();
        tree.setMaxWidth(600);
        tree.setProps(Map.of("label", "label", "children", "children"));
        tree.setNodeKey(NodeData::id);
        tree.setDraggable(true);
        tree.setDefaultExpandAll(true);
        tree.setData(data);

        // Level three 3-1-1 不能被拖起。
        tree.setAllowDrag(node ->
                !node.getValue().label().contains("Level three 3-1-1"));

        // 允许放在 Level two 3-1 的前后，禁止放到它里面。
        tree.setAllowDrop(drop ->
                drop.position() != EleFXTree.DropPosition.INSIDE
                        || !"Level two 3-1".equals(drop.target().getValue().label()));

        tree.setOnNodeDragStart(source ->
                System.out.println("drag start: " + source.getValue().label()));

        tree.setOnNodeDragEnter((source, target) ->
                System.out.println("tree drag enter: " + target.getValue().label()));

        tree.setOnNodeDragLeave((source, target) ->
                System.out.println("tree drag leave: " + target.getValue().label()));

        tree.setOnNodeDragOver((source, target) ->
                System.out.println("tree drag over: " + target.getValue().label()));

        tree.setOnNodeDragEnd(drop -> {
            if (drop.target() == null) {
                System.out.println("tree drag end: none");
            } else {
                System.out.println("tree drag end: "
                        + drop.target().getValue().label() + " " + drop.position());
            }
        });

        tree.setOnNodeDrop(drop ->
                System.out.println("tree drop: "
                        + drop.target().getValue().label() + " " + drop.position()));

        return tree;
    }

    private EleFXTreeFiller() {
    }
}
