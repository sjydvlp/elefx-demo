package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.input.EleFXInput;
import com.sjydvlp.elefx.component.input.EleFXInputSize;
import com.sjydvlp.elefx.component.link.EleFXLink;
import com.sjydvlp.elefx.component.link.EleFXLinkType;
import com.sjydvlp.elefx.component.popover.EleFXPopover;
import com.sjydvlp.elefx.component.popover.EleFXPopoverEffect;
import com.sjydvlp.elefx.component.popover.EleFXPopoverPlacement;
import com.sjydvlp.elefx.component.popover.EleFXPopoverTrigger;
import com.sjydvlp.elefx.component.radio.EleFXRadioButton;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.component.switcher.EleFXSwitch;
import com.sjydvlp.elefx.component.table.*;
import com.sjydvlp.elefx.component.tag.EleFXTag;
import com.sjydvlp.elefx.component.tag.EleFXTagType;
import javafx.animation.PauseTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * EleFXTableFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTableFiller {

    public static void fill(VBox vBox) {
//        vBox.getChildren().add(basicUsageTest());
//        vBox.getChildren().add(stripedTableTest());
//        vBox.getChildren().add(tableWithBorderTest());
//        vBox.getChildren().add(tableWithStatusTest());
//        vBox.getChildren().add(showOverflowTooltipTest());
//        vBox.getChildren().add(fixedHeaderTest());
//        vBox.getChildren().add(fixedColumnTest());
//        vBox.getChildren().add(fixedColumnAndHeaderTest());
//        vBox.getChildren().add(fluidHeightTableTest());
//        vBox.getChildren().add(groupingTableHeadTest());
//        vBox.getChildren().add(fixedGroupHeaderTest());
//        vBox.getChildren().add(singleSelectTest());
//        vBox.getChildren().add(multipleSelectTest());
//        vBox.getChildren().add(sortingTest());
//        vBox.getChildren().add(filterTest());
//        vBox.getChildren().add(customColumnTemplateTest());
//        vBox.getChildren().add(customHeaderTest());
//        vBox.getChildren().add(expandableRowTest());
//        vBox.getChildren().add(treeDataAndLazyModeTest());
//        vBox.getChildren().add(selectableTreeTest());
//        vBox.getChildren().add(summaryRowTest());
//        vBox.getChildren().add(rowspanAndColspanTest());
//        vBox.getChildren().add(customIndexTest());
//        vBox.getChildren().add(tableLayoutTest());
        vBox.getChildren().add(tooltipFormatterTest());
        vBox.setSpacing(10);
    }

    private static VBox basicUsageTest() {
        record Row(
                String date,
                String name,
                String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<Row> tableData = FXCollections.observableArrayList(
                new Row("2016-05-03", "Tom", address),
                new Row("2016-05-02", "Tom", address),
                new Row("2016-05-04", "Tom", address),
                new Row("2016-05-01", "Tom", address));

        EleFXTableColumn<Row, String> dateColumn = new EleFXTableColumn<Row, String>("Date");
        dateColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().date()));
        dateColumn.setMinWidth(180);
        dateColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> nameColumn = new EleFXTableColumn<Row, String>("Name");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().name()));
        nameColumn.setMinWidth(180);
        nameColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> addressColumn = new EleFXTableColumn<Row, String>("Address");
        addressColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));

        EleFXTable<Row> table = new EleFXTable<>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(addressColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox root = new VBox();
        root.getChildren().addAll(table, new Label("标记文本"));
        root.setSpacing(10);

        return root;
    }

    private static VBox stripedTableTest() {
        record Row(
                String date,
                String name,
                String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<Row> tableData = FXCollections.observableArrayList(
                new Row("2016-05-03", "Tom", address),
                new Row("2016-05-02", "Tom", address),
                new Row("2016-05-04", "Tom", address),
                new Row("2016-05-01", "Tom", address));

        EleFXTableColumn<Row, String> dateColumn = new EleFXTableColumn<Row, String>("Date");
        dateColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().date()));
        dateColumn.setMinWidth(180);
        dateColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> nameColumn = new EleFXTableColumn<Row, String>("Name");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().name()));
        nameColumn.setMinWidth(180);
        nameColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> addressColumn = new EleFXTableColumn<Row, String>("Address");
        addressColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));

        EleFXTable<Row> table = new EleFXTable<Row>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(addressColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setStripe(true);

        VBox root = new VBox();
        root.getChildren().addAll(table, new Label("标记文本"));
        root.setSpacing(10);

        return root;
    }

    private static VBox tableWithBorderTest() {
        record Row(
                String date,
                String name,
                String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<Row> tableData = FXCollections.observableArrayList(
                new Row("2016-05-03", "Tom", address),
                new Row("2016-05-02", "Tom", address),
                new Row("2016-05-04", "Tom", address),
                new Row("2016-05-01", "Tom", address));

        EleFXTableColumn<Row, String> dateColumn = new EleFXTableColumn<Row, String>("Date");
        dateColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().date()));
        dateColumn.setPrefWidth(180);

        EleFXTableColumn<Row, String> nameColumn = new EleFXTableColumn<Row, String>("Name");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().name()));
        nameColumn.setPrefWidth(180);

        EleFXTableColumn<Row, String> addressColumn = new EleFXTableColumn<Row, String>("Address");
        addressColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));

        EleFXTable<Row> table = new EleFXTable<Row>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(addressColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setBordered(true);

        VBox root = new VBox();
        root.getChildren().addAll(table, new Label("标记文本"));
        root.setSpacing(10);

        return root;
    }

    private static VBox tableWithStatusTest() {
        record Row(
                String date,
                String name,
                String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<Row> tableData = FXCollections.observableArrayList(
                new Row("2016-05-03", "Tom", address),
                new Row("2016-05-02", "Tom", address),
                new Row("2016-05-04", "Tom", address),
                new Row("2016-05-01", "Tom", address));

        EleFXTableColumn<Row, String> dateColumn = new EleFXTableColumn<Row, String>("Date");
        dateColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().date()));
        dateColumn.setMinWidth(180);
        dateColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> nameColumn = new EleFXTableColumn<Row, String>("Name");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().name()));
        nameColumn.setMinWidth(180);
        nameColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> addressColumn = new EleFXTableColumn<Row, String>("Address");
        addressColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));

        EleFXTable<Row> table = new EleFXTable<Row>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(addressColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        PseudoClass warning = PseudoClass.getPseudoClass("warning");
        PseudoClass success = PseudoClass.getPseudoClass("success");

        table.setRowFactory(view -> {
            TableRow<Row> row = new TableRow<Row>();

            Runnable updateStatus = () -> {
                int index = row.getIndex();
                row.pseudoClassStateChanged(warning, !row.isEmpty() && index == 1);
                row.pseudoClassStateChanged(success, !row.isEmpty() && index == 3);
            };

            row.indexProperty().addListener(observable -> updateStatus.run());
            row.emptyProperty().addListener(observable -> updateStatus.run());
            return row;
        });

        VBox root = new VBox();
        root.getChildren().addAll(table, new Label("标记文本"));
        root.setSpacing(10);

        return root;
    }

    private static VBox showOverflowTooltipTest() {
        record Row(
                String date,
                String name,
                String address) {
        }

        ObservableList<Row> tableData = FXCollections.observableArrayList(
                new Row("2016-05-04", "Aleyna Kutzner",
                        "Lohrbergstr. 86c, Süd Lilli, Saarland"),
                new Row("2016-05-03", "Helen Jacobi",
                        "760 A Street, South Frankfield, Illinois"),
                new Row("2016-05-02", "Brandon Deckert",
                        "Arnold-Ohletz-Str. 41a, Alt Malinascheid, Thüringen"),
                new Row("2016-05-01", "Margie Smith",
                        "23618 Windsor Drive, West Ricardoview, Idaho"));

        Map<Row, BooleanProperty> checkedRows = new IdentityHashMap<>();
        for (Row row : tableData) {
            checkedRows.put(row, new SimpleBooleanProperty(false));
        }

        CheckBox selectAll = new CheckBox();
        selectAll.setAccessibleText("Select all rows");

        Runnable updateSelectAll = () -> {
            long checkedCount = checkedRows.values().stream()
                    .filter(BooleanProperty::get)
                    .count();

            selectAll.setSelected(checkedCount == tableData.size());
            selectAll.setIndeterminate(
                    checkedCount > 0 && checkedCount < tableData.size());
        };

        for (BooleanProperty checked : checkedRows.values()) {
            checked.addListener((observable, oldValue, newValue) -> updateSelectAll.run());
        }

        selectAll.setOnAction(event -> {
            boolean checkAll = checkedRows.values().stream()
                    .anyMatch(checked -> !checked.get());

            for (BooleanProperty checked : checkedRows.values()) {
                checked.set(checkAll);
            }
        });

        EleFXTableColumn<Row, Boolean> selectionColumn = new EleFXTableColumn<>("");
        selectionColumn.setGraphic(selectAll);
        selectionColumn.setMinWidth(55);
        selectionColumn.setMaxWidth(55);
        selectionColumn.setCellValueFactory(cell -> checkedRows.get(cell.getValue()));
        selectionColumn.setCellFactory(
                CheckBoxTableCell.forTableColumn(selectionColumn));

        EleFXTableColumn<Row, String> dateColumn = new EleFXTableColumn<>("Date");
        dateColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().date()));
        dateColumn.setMinWidth(120);
        dateColumn.setMaxWidth(120);
        dateColumn.setEditable(false);

        EleFXTableColumn<Row, String> nameColumn = new EleFXTableColumn<>("Name");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().name()));
        nameColumn.setMinWidth(120);
        nameColumn.setMaxWidth(120);
        nameColumn.setEditable(false);

        EleFXTableColumn<Row, String> tooltipColumn = new EleFXTableColumn<>("use show-overflow-tooltip");
        tooltipColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));
        tooltipColumn.setMinWidth(240);
        tooltipColumn.setMaxWidth(240);
        tooltipColumn.setShowOverflowTooltip(true);
        tooltipColumn.setEditable(false);

        EleFXTableColumn<Row, String> addressColumn = new EleFXTableColumn<>("address");
        addressColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));
        addressColumn.setEditable(false);

        EleFXTable<Row> table = new EleFXTable<>(tableData);
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().add(selectionColumn);
        table.getColumns().add(dateColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(tooltipColumn);
        table.getColumns().add(addressColumn);

        VBox root = new VBox();
        root.getChildren().addAll(table, new Label("标记文本"));
        root.setSpacing(10);

        return root;
    }

    private static VBox fixedHeaderTest() {
        record Row(
                String date,
                String name,
                String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<Row> tableData = FXCollections.observableArrayList(
                new Row("2016-05-03", "Tom", address),
                new Row("2016-05-02", "Tom", address),
                new Row("2016-05-04", "Tom", address),
                new Row("2016-05-01", "Tom", address),
                new Row("2016-05-08", "Tom", address),
                new Row("2016-05-06", "Tom", address),
                new Row("2016-05-07", "Tom", address));

        EleFXTableColumn<Row, String> dateColumn = new EleFXTableColumn<Row, String>("Date");
        dateColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().date()));
        dateColumn.setMinWidth(180);
        dateColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> nameColumn = new EleFXTableColumn<Row, String>("Name");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().name()));
        nameColumn.setMinWidth(180);
        nameColumn.setMaxWidth(180);

        EleFXTableColumn<Row, String> addressColumn = new EleFXTableColumn<Row, String>("Address");
        addressColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().address()));

        EleFXTable<Row> table = new EleFXTable<Row>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(addressColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(250);

        VBox root = new VBox();
        root.getChildren().addAll(table, new Label("标记文本"));
        root.setSpacing(10);

        return root;
    }

    private static VBox fixedColumnTest() {
        record FixedColumnRow(
                String date,
                String name,
                String state,
                String city,
                String address,
                String zip) {
        }

        record ColumnSpec(String title, double width, Function<FixedColumnRow, String> getter) {
        }

        Function<ColumnSpec, EleFXTableColumn<FixedColumnRow, String>> textColumn = spec -> {
            var column = new EleFXTableColumn<FixedColumnRow, String>(spec.title());
            column.setMinWidth(spec.width());
            column.setMaxWidth(spec.width());
            column.setValueGetter(spec.getter());
            return column;
        };

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<FixedColumnRow> tableData = FXCollections.observableArrayList(
                new FixedColumnRow("2016-05-03", "Tom", "California",
                        "Los Angeles", address, "CA 90036"),
                new FixedColumnRow("2016-05-02", "Tom", "California",
                        "Los Angeles", address, "CA 90036"),
                new FixedColumnRow("2016-05-04", "Tom", "California",
                        "Los Angeles", address, "CA 90036"),
                new FixedColumnRow("2016-05-01", "Tom", "California",
                        "Los Angeles", address, "CA 90036"));

        EleFXTableColumn<FixedColumnRow, String> dateColumn = textColumn
                .apply(new ColumnSpec("Date", 150, FixedColumnRow::date));
        dateColumn.setFixed(EleFXTableColumnFixed.LEFT);

        EleFXTableColumn<FixedColumnRow, Void> operationsColumn = new EleFXTableColumn<>("Operations");
        operationsColumn.setFixed(EleFXTableColumnFixed.RIGHT);
        operationsColumn.setMinWidth(150);
        operationsColumn.setMaxWidth(150);
        operationsColumn.setCellGraphicFactory(row -> {
            var detail = new EleFXButton("Detail", EleFXButtonType.PRIMARY);
            detail.setLink(true);
            detail.setOnAction(event -> System.out.println("Detail: " + row.date));

            var edit = new EleFXButton("Edit", EleFXButtonType.PRIMARY);
            edit.setLink(true);
            edit.setOnAction(event -> System.out.println("Edit: " + row.date));

            HBox hBox = new HBox(8, detail, edit);
            hBox.setAlignment(Pos.CENTER_LEFT);
            return hBox;
        });

        EleFXTable<FixedColumnRow> table = new EleFXTable<>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(textColumn.apply(new ColumnSpec("Name", 120, row -> row.name)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("State", 120, row -> row.state)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("City", 120, row -> row.city)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("Address", 600, row -> row.address)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("Zip", 120, row -> row.zip)));
        table.getColumns().add(operationsColumn);
        table.setFixedCellSize(40);

        VBox root = new VBox(10, table);

        return root;
    }

    private static VBox fixedColumnAndHeaderTest() {
        record FixedColumnRow(
                String date,
                String name,
                String state,
                String city,
                String address,
                String zip) {
        }

        record ColumnSpec(String title, double width, Function<FixedColumnRow, String> getter) {
        }

        Function<ColumnSpec, EleFXTableColumn<FixedColumnRow, String>> textColumn = spec -> {
            var column = new EleFXTableColumn<FixedColumnRow, String>(spec.title());
            column.setMinWidth(spec.width());
            column.setMaxWidth(spec.width());
            column.setValueGetter(spec.getter());
            return column;
        };

        String address = "No. 189, Grove St, Los Angeles";
        ObservableList<FixedColumnRow> tableData = FXCollections.observableArrayList();

        for (String day : new String[] {"03", "02", "04", "01", "08", "06", "07"}) {
            tableData.add(new FixedColumnRow(
                    "2016-05-" + day, "Tom", "California",
                    "Los Angeles", address, "CA 90036"));
        }

        EleFXTableColumn<FixedColumnRow, String> dateColumn = textColumn
                .apply(new ColumnSpec("Date", 150, row -> row.date));
        dateColumn.setFixed(EleFXTableColumnFixed.LEFT);

        EleFXTableColumn<FixedColumnRow, String> zipColumn = new EleFXTableColumn<>("Zip");
        zipColumn.setValueGetter(row -> row.zip);

        EleFXTable<FixedColumnRow> table = new EleFXTable<>(tableData);
        table.getColumns().add(dateColumn);
        table.getColumns().add(textColumn.apply(new ColumnSpec("Name", 120, row -> row.name)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("State", 120, row -> row.state)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("City", 320, row -> row.city)));
        table.getColumns().add(textColumn.apply(new ColumnSpec("Address", 600, row -> row.address)));
        table.getColumns().add(zipColumn);

        table.setPrefHeight(250);
        table.setMinHeight(Region.USE_PREF_SIZE);
        table.setMaxHeight(Region.USE_PREF_SIZE);
        table.setMinWidth(0);
        table.setMaxWidth(Double.MAX_VALUE);

        return new VBox(10, table);
    }

    private static VBox fluidHeightTableTest() {
        record Row(String date, String name, String state,
                String city, String address, String zip) {
        }

        Function<String, Row> createRow = date -> new Row(
                date, "Tom", "California", "Los Angeles",
                "No. 189, Grove St, Los Angeles", "CA 90036");

        ObservableList<Row> rows = FXCollections.observableArrayList(
                createRow.apply("2016-05-01"),
                createRow.apply("2016-05-02"),
                createRow.apply("2016-05-03"));

        EleFXTable<Row> table = new EleFXTable<>(rows);
        table.setMaxHeight(250);
        table.setMaxWidth(Double.MAX_VALUE);

        record ColumnSpec(String title, double width, Function<Row, String> getter) {
        }

        for (ColumnSpec spec : java.util.List.of(
                new ColumnSpec("Date", 150, Row::date),
                new ColumnSpec("Name", 120, Row::name),
                new ColumnSpec("State", 120, Row::state),
                new ColumnSpec("City", 120, Row::city),
                new ColumnSpec("Address", 600, Row::address),
                new ColumnSpec("Zip", 120, Row::zip))) {
            EleFXTableColumn<Row, String> column = new EleFXTableColumn<>(spec.title());
            column.setPrefWidth(spec.width());
            column.setSortable(false);
            column.setValueGetter(spec.getter());
            if ("Date".equals(spec.title())) {
                column.setFixed(EleFXTableColumnFixed.LEFT);
            }
            table.getColumns().add(column);
        }

        EleFXTableColumn<Row, Row> operations = new EleFXTableColumn<>("Operations");
        operations.setFixed(EleFXTableColumnFixed.RIGHT);
        operations.setMinWidth(120);
        operations.setPrefWidth(120);
        operations.setSortable(false);
        operations.setValueGetter(Function.identity());
        operations.setCellGraphicFactory(row -> {
            EleFXButton remove = new EleFXButton(
                    "Remove", EleFXButtonType.PRIMARY, EleFXButtonSize.SMALL);
            remove.setLink(true);
            remove.setOnAction(event -> rows.removeIf(item -> item == row));
            return remove;
        });
        table.getColumns().add(operations);

        LocalDate today = LocalDate.now();
        EleFXButton addItem = new EleFXButton("Add Item") {

            private LocalDate nextDate = today.plusDays(1);

            {
                setOnAction(event -> {
                    rows.add(createRow.apply(nextDate.toString()));
                    nextDate = nextDate.plusDays(1);
                });
            }
        };
        addItem.setMaxWidth(Double.MAX_VALUE);

        return new VBox(10, table, addItem);
    }

    private static VBox groupingTableHeadTest() {
        record Row(
                String date,
                String name,
                String state,
                String city,
                String address,
                String zip) {
        }

        var rows = FXCollections.<Row>observableArrayList();
        for (String date : List.of(
                "2016-05-03", "2016-05-02", "2016-05-04", "2016-05-01",
                "2016-05-08", "2016-05-06", "2016-05-07")) {
            rows.add(new Row(
                    date, "Tom", "California", "Los Angeles",
                    "No. 189, Grove St, Los Angeles", "CA 90036"));
        }

        var table = new EleFXTable<>(rows);
        table.setMaxWidth(Double.MAX_VALUE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        BiFunction<String, Function<Row, String>, EleFXTableColumn<Row, String>> textColumn = (title, getter) -> {
            var column = new EleFXTableColumn<Row, String>(title);
            column.setValueGetter(getter);
            column.setSortable(false);
            return column;
        };

        var date = textColumn.apply("Date", Row::date);
        date.setMinWidth(150);
        date.setMaxWidth(150);

        var name = textColumn.apply("Name", Row::name);
        var state = textColumn.apply("State", Row::state);
        var city = textColumn.apply("City", Row::city);
        var address = textColumn.apply("Address", Row::address);
        var zip = textColumn.apply("Zip", Row::zip);

        for (var column : List.of(name, state, city, zip)) {
            column.setMinWidth(120);
            column.setMaxWidth(120);
        }

        var addressInfo = new EleFXTableColumn<Row, Void>("Address Info");
        addressInfo.getColumns().setAll(List.of(state, city, address, zip));

        var deliveryInfo = new EleFXTableColumn<Row, Void>("Delivery Info");
        deliveryInfo.getColumns().setAll(List.of(name, addressInfo));

        table.getColumns().setAll(List.of(date, deliveryInfo));

        return new VBox(10, table);
    }

    private static VBox fixedGroupHeaderTest() {
        record Row(
                String date,
                String name,
                String state,
                String city,
                String address,
                String zip) {
        }

        var rows = FXCollections.<Row>observableArrayList();
        for (String date : List.of(
                "2016-05-03", "2016-05-02", "2016-05-04", "2016-05-01",
                "2016-05-08", "2016-05-06", "2016-05-07")) {
            rows.add(new Row(
                    date, "Tom", "California", "Los Angeles",
                    "No. 189, Grove St, Los Angeles", "CA 90036"));
        }

        var table = new EleFXTable<>(rows);
        table.setMinHeight(250);
        table.setPrefHeight(250);
        table.setMaxHeight(250);
        table.setMaxWidth(Double.MAX_VALUE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        BiFunction<String, Function<Row, String>, EleFXTableColumn<Row, String>> textColumn = (title, getter) -> {
            var column = new EleFXTableColumn<Row, String>(title);
            column.setValueGetter(getter);
            column.setSortable(false);
            return column;
        };

        var date = textColumn.apply("Date", Row::date);
        var name = textColumn.apply("Name", Row::name);
        var zip = textColumn.apply("Zip", Row::zip);
        var state = textColumn.apply("State", Row::state);
        var city = textColumn.apply("City", Row::city);
        var address = textColumn.apply("Address", Row::address);

        date.setMinWidth(138);
        date.setMaxWidth(138);

        for (var column : List.of(name, zip, state, city)) {
            column.setMinWidth(134);
            column.setMaxWidth(134);
        }

        // 只设置最小宽度，Address 会占用剩余空间。
        address.setMinWidth(200);

        var addressInfo = new EleFXTableColumn<Row, Void>("Address Info");
        addressInfo.setFixed(EleFXTableColumnFixed.RIGHT);
        addressInfo.getColumns().setAll(List.of(state, city, address));

        table.getColumns().setAll(List.of(date, name, zip, addressInfo));

        return new VBox(10, table);
    }

    private static VBox singleSelectTest() {
        record User(String date, String name, String address) {
        }

        var rows = FXCollections.<User>observableArrayList();
        for (String date : List.of(
                "2016-05-03", "2016-05-02", "2016-05-04", "2016-05-01")) {
            rows.add(new User(date, "Tom", "No. 189, Grove St, Los Angeles"));
        }

        var table = new EleFXTable<>(rows);
        table.setMaxWidth(Double.MAX_VALUE);
        table.setHighlightCurrentRow(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var selection = table.getSelectionModel();
        selection.setSelectionMode(SelectionMode.SINGLE);

        // 对应 Element Plus 的 current-change，清除选中时值为 null。
        var currentRow = new SimpleObjectProperty<User>();
        selection.selectedItemProperty().addListener(
                (observable, previous, current) -> currentRow.set(current));

        var index = new EleFXTableColumn<User, User>();
        index.setMinWidth(50);
        index.setMaxWidth(50);
        index.setSortable(false);
        index.setValueGetter(Function.identity());
        index.setCellFactory(column -> new TableCell<User, User>() {

            @Override
            protected void updateItem(User item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : Integer.toString(getIndex() + 1));
            }
        });

        BiFunction<String, Function<User, String>, EleFXTableColumn<User, String>> textColumn = (title, getter) -> {
            var column = new EleFXTableColumn<User, String>(title);
            column.setValueGetter(getter);
            column.setSortable(false);
            return column;
        };

        var date = textColumn.apply("Date", User::date);
        var name = textColumn.apply("Name", User::name);
        var address = textColumn.apply("Address", User::address);

        for (var column : List.of(date, name)) {
            column.setMinWidth(120);
            column.setMaxWidth(120);
        }

        table.getColumns().setAll(List.of(index, date, name, address));

        var selectSecond = new EleFXButton("Select second row");
        selectSecond.setOnAction(event -> selection.select(1));

        var clearSelection = new EleFXButton("Clear selection");
        clearSelection.setOnAction(event -> selection.clearSelection());

        var buttons = new HBox(12, selectSecond, clearSelection);

        return new VBox(10, table, buttons);
    }

    private static VBox multipleSelectTest() {
        record User(int id, String date, String name, String address) {
        }

        var dates = List.of(
                "2016-05-03", "2016-05-02", "2016-05-04", "2016-05-01",
                "2016-05-08", "2016-05-06", "2016-05-07");

        var rows = FXCollections.<User>observableArrayList();
        for (int i = 0; i < dates.size(); i++) {
            rows.add(new User(
                    i + 1, dates.get(i), "Tom", "No. 189, Grove St, Los Angeles"));
        }

        var table = new EleFXTable<>(rows);
        table.setMaxWidth(Double.MAX_VALUE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var selectionColumn = new EleFXTableSelectionColumn<User>(User::id);
        selectionColumn.setSelectable(row -> row.id() != 1 && row.id() != 2);

        var date = new EleFXTableColumn<User, String>("Date");
        date.setValueGetter(User::date);

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);

        var address = new EleFXTableColumn<User, String>("Address");
        address.setValueGetter(User::address);

        for (var column : List.of(date, name)) {
            column.setMinWidth(120);
            column.setMaxWidth(120);
        }

        table.getColumns().setAll(List.of(selectionColumn, date, name, address));

        var targetRows = List.of(rows.get(1), rows.get(2));

        var toggleBoth = new EleFXButton("Toggle selection status of second and third rows");
        toggleBoth.setOnAction(event -> targetRows.forEach(table::toggleRowSelection));

        var toggleSelectable = new EleFXButton("Toggle selection status based on selectable");
        toggleSelectable.setOnAction(event -> targetRows.forEach(row -> table.toggleRowSelection(row, null, false)));

        var clearSelection = new EleFXButton("Clear selection");
        clearSelection.setOnAction(event -> table.clearSelection());

        var buttons = new FlowPane(12, 8, toggleBoth, toggleSelectable, clearSelection);

        return new VBox(10, table, buttons);
    }

    private static VBox sortingTest() {
        record User(String date, String name, String address) {
        }

        var rows = FXCollections.<User>observableArrayList();
        for (String date : List.of(
                "2016-05-03", "2016-05-02", "2016-05-04", "2016-05-01")) {
            rows.add(new User(date, "Tom", "No. 189, Grove St, Los Angeles"));
        }

        var table = new EleFXTable<>(rows);
        table.setMaxWidth(Double.MAX_VALUE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var date = new EleFXTableColumn<User, String>("Date");
        date.setValueGetter(User::date);
        date.setSortable(true);

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);
        name.setSortable(true);

        var address = new EleFXTableColumn<User, String>("Address");
        address.setValueGetter(User::address);

        // Date 和 Name 各占 180 px，Address 占用剩余宽度。
        for (var column : List.of(date, name)) {
            column.setMinWidth(180);
            column.setMaxWidth(180);
        }

        table.getColumns().setAll(List.of(date, name, address));

        // 对应 default-sort="{ prop: 'date', order: 'descending' }"。
        date.setSortType(TableColumn.SortType.DESCENDING);
        table.getSortOrder().setAll(List.of(date));

        return new VBox(10, table);
    }

    private static VBox filterTest() {
        record User(String date, String name, String address, String tag) {
        }

        String street = "No. 189, Grove St, Los Angeles";
        var rows = FXCollections.observableArrayList(
                new User("2016-05-03", "Tom", street, "Home"),
                new User("2016-05-02", "Tom", street, "Office"),
                new User("2016-05-04", "Tom", street, "Home"),
                new User("2016-05-01", "Tom", street, "Office"));

        var table = new EleFXTable<User>();
        table.setFilterItems(rows);
        table.setMaxWidth(Double.MAX_VALUE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var date = new EleFXTableFilterColumn<User, String>("Date");
        date.setId("date");
        date.setValueGetter(User::date);
        date.setSortable(true);
        date.setFilters(List.of(
                "2016-05-01", "2016-05-02", "2016-05-03", "2016-05-04"));

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);

        var address = new EleFXTableColumn<User, String>("Address");
        address.setValueGetter(User::address);

        var tag = new EleFXTableFilterColumn<User, String>("Tag");
        tag.setValueGetter(User::tag);
        tag.setFilters(List.of("Home", "Office"));
        tag.setCellGraphicFactory(row -> new EleFXTag(
                row.tag(),
                "Home".equals(row.tag()) ? EleFXTagType.PRIMARY : EleFXTagType.SUCCESS));

        // 固定 Date、Name 和 Tag 的宽度，Address 占用剩余空间。
        for (var column : List.of(date, name)) {
            column.setMinWidth(180);
            column.setMaxWidth(180);
        }
        tag.setMinWidth(100);
        tag.setMaxWidth(100);

        table.getColumns().setAll(List.of(date, name, address, tag));

        var resetDate = new EleFXButton("reset date filter");
        resetDate.setOnAction(event -> table.clearFilter("date"));

        var resetAll = new EleFXButton("reset all filters");
        resetAll.setOnAction(event -> table.clearFilter());

        return new VBox(10, new HBox(8, resetDate, resetAll), table);
    }

    private static VBox customColumnTemplateTest() {
        record User(String date, String name, String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        var table = new EleFXTable<>(FXCollections.observableArrayList(
                new User("2016-05-03", "Tom", address),
                new User("2016-05-02", "Tom", address),
                new User("2016-05-04", "Tom", address),
                new User("2016-05-01", "Tom", address)));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var date = new EleFXTableColumn<User, String>("Date");
        date.setPrefWidth(180);
        date.setResizable(false);
        date.setCellGraphicFactory(user -> {
            var content = new HBox(10,
                    new EleFXIcon(EleFXIconType.TIMER, 14),
                    new Label(user.date()));
            content.setAlignment(Pos.CENTER_LEFT);
            return content;
        });

        var name = new EleFXTableColumn<User, String>("Name");
        name.setPrefWidth(180);
        name.setResizable(false);
        name.setCellGraphicFactory(user -> {
            var tag = new EleFXTag(user.name());
            var popover = new EleFXPopover(
                    tag, "name: " + user.name() + "\naddress: " + user.address());
            popover.setTrigger(EleFXPopoverTrigger.HOVER);
            popover.setPlacement(EleFXPopoverPlacement.TOP);
            popover.setEffect(EleFXPopoverEffect.LIGHT);
            popover.setWidth(EleFXPopover.AUTO_WIDTH);
            tag.sceneProperty().addListener((observable, oldScene, scene) -> {
                if (scene == null) {
                    popover.hide();
                }
            });
            return tag;
        });

        var operations = new EleFXTableColumn<User, Void>("Operations");
        operations.setSortable(false);
        operations.setMinWidth(150);
        operations.setCellGraphicFactory(user -> {
            var edit = new EleFXButton(
                    "Edit", EleFXButtonType.DEFAULT, EleFXButtonSize.SMALL);
            var delete = new EleFXButton(
                    "Delete", EleFXButtonType.DANGER, EleFXButtonSize.SMALL);

            edit.setOnAction(event -> System.out.printf(
                    "Edit %d %s%n", table.getItems().indexOf(user), user));
            delete.setOnAction(event -> System.out.printf(
                    "Delete %d %s%n", table.getItems().indexOf(user), user));

            var buttons = new HBox(8, edit, delete);
            buttons.setAlignment(Pos.CENTER_LEFT);
            return buttons;
        });

        table.getColumns().setAll(date, name, operations);

        return new VBox(10, table);
    }

    private static VBox customHeaderTest() {
        record User(String date, String name, String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        var users = FXCollections.observableArrayList(
                new User("2016-05-03", "Tom", address),
                new User("2016-05-02", "John", address),
                new User("2016-05-04", "Morgan", address),
                new User("2016-05-01", "Jessy", address));
        var filteredUsers = new FilteredList<>(users);
        var table = new EleFXTable<>(filteredUsers);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var date = new EleFXTableColumn<User, String>("Date");
        date.setValueGetter(User::date);
        date.setSortable(false);

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);
        name.setSortable(false);

        var search = new EleFXInput();
        search.setSize(EleFXInputSize.SMALL);
        search.setPromptText("Type to search");
        search.textProperty().addListener((observable, oldValue, value) -> {
            String query = value == null ? "" : value.toLowerCase(Locale.ROOT);
            filteredUsers.setPredicate(user -> user.name().toLowerCase(Locale.ROOT).contains(query));
        });

        var operations = new EleFXTableColumn<User, User>();
        operations.setGraphic(search);
        operations.setSortable(false);
        operations.setMinWidth(160);
        search.prefWidthProperty().bind(operations.widthProperty().subtract(24));

        operations.setCellGraphicFactory(user -> {
            var edit = new EleFXButton(
                    "Edit", EleFXButtonType.DEFAULT, EleFXButtonSize.SMALL);
            var delete = new EleFXButton(
                    "Delete", EleFXButtonType.DANGER, EleFXButtonSize.SMALL);

            edit.setOnAction(event -> System.out.printf("Edit %d %s%n", filteredUsers.indexOf(user), user));
            delete.setOnAction(event -> System.out.printf("Delete %d %s%n", filteredUsers.indexOf(user), user));

            var buttons = new HBox(8, edit, delete);
            buttons.setAlignment(Pos.CENTER_RIGHT);
            buttons.prefWidthProperty().bind(operations.widthProperty().subtract(24));
            return buttons;
        });

        table.getColumns().setAll(date, name, operations);

        return new VBox(10, table);
    }

    private static VBox expandableRowTest() {
        record Family(String name, String state, String city, String address, String zip) {
        }
        record User(String date, String name, String state, String city,
                String address, String zip, List<Family> family) {
        }

        String state = "California";
        String city = "San Francisco";
        String address = "3650 21st St, San Francisco";
        String zip = "CA 94114";

        var family = List.of(
                new Family("Jerry", state, city, address, zip),
                new Family("Spike", state, city, address, zip),
                new Family("Tyke", state, city, address, zip));

        var users = Stream.of(
                "2016-05-03", "2016-05-02", "2016-05-04", "2016-05-01",
                "2016-05-08", "2016-05-06", "2016-05-07")
                .map(date -> new User(date, "Tom", state, city, address, zip, family))
                .toList();

        var parentBorder = new EleFXSwitch();
        var childBorder = new EleFXSwitch();
        var preserveExpanded = new EleFXSwitch();

        var controls = new HBox(8,
                new Label("Parent border"), parentBorder,
                new Label("Child border"), childBorder,
                new Label("Preserve expanded"), preserveExpanded);
        controls.setAlignment(Pos.CENTER_LEFT);

        BiFunction<String, Function<Family, String>, EleFXTableColumn<Family, String>> familyColumn = (title,
                                                                                                       getter) -> {
            var column = new EleFXTableColumn<Family, String>(title);
            column.setValueGetter(getter);
            return column;
        };

        var expand = new EleFXTableExpandColumn<User>(row -> {
            var child = new EleFXTable<>(FXCollections.observableArrayList(row.family()));
            child.borderedProperty().bind(childBorder.selectedProperty());
            child.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            child.getColumns().setAll(List.of(
                    familyColumn.apply("Name", Family::name),
                    familyColumn.apply("State", Family::state),
                    familyColumn.apply("City", Family::city),
                    familyColumn.apply("Address", Family::address),
                    familyColumn.apply("Zip", Family::zip)));

            var familyHeading = new Label("Family");
            familyHeading.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: -elefx-ct-regular;");
            var details = new VBox(8,
                    new Label("State: " + row.state()),
                    new Label("City: " + row.city()),
                    new Label("Address: " + row.address()),
                    new Label("Zip: " + row.zip()),
                    familyHeading,
                    child);
            details.setPadding(new Insets(0, 16, 0, 16));
            return details;
        });

        var date = new EleFXTableColumn<User, String>("Date");
        date.setValueGetter(User::date);

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);

        var table = new EleFXTable<>(FXCollections.observableArrayList(users));
        table.getColumns().setAll(List.of(expand, date, name));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.borderedProperty().bind(parentBorder.selectedProperty());
        table.preserveExpandedContentProperty().bind(preserveExpanded.selectedProperty());

        return new VBox(10, controls, table);
    }

    private static VBox treeDataAndLazyModeTest() {
        record User(
                int id,
                String date,
                String name,
                String address,
                List<User> children,
                boolean hasChildren) {
        }

        String name = "wangxiaohu";
        String address = "No. 189, Grove St, Los Angeles";

        var children = List.of(
                new User(31, "2016-05-01", name, address, List.of(), false),
                new User(32, "2016-05-01", name, address, List.of(), false));

        var demo = new VBox(20);

        for (boolean lazy : List.of(false, true)) {
            var rows = FXCollections.observableArrayList(
                    new User(1, "2016-05-02", name, address, List.of(), false),
                    new User(2, "2016-05-04", name, address, List.of(), false),
                    new User(3, "2016-05-01", name, address,
                            lazy ? List.of() : children, lazy),
                    new User(4, "2016-05-03", name, address, List.of(), false));

            var table = new EleFXTable<>(rows);
            table.setBordered(true);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.setRowKey(User::id);

            if (lazy) {
                table.setHasChildrenGetter(User::hasChildren);
                table.setTreeLoader((user, resolve) -> {
                    var delay = new PauseTransition(Duration.seconds(2));
                    delay.setOnFinished(event -> resolve.accept(children));
                    delay.play();
                });
            } else {
                table.setChildrenGetter(User::children);
                table.setDefaultExpandAll(true);
            }

            var dateColumn = new EleFXTableColumn<User, String>("Date");
            dateColumn.setValueGetter(User::date);

            var nameColumn = new EleFXTableColumn<User, String>("Name");
            nameColumn.setValueGetter(User::name);

            var addressColumn = new EleFXTableColumn<User, String>("Address");
            addressColumn.setValueGetter(User::address);

            var columns = List.of(dateColumn, nameColumn, addressColumn);
            columns.forEach(column -> column.setSortable(!lazy));
            table.getColumns().setAll(columns);

            demo.getChildren().add(table);
        }
        return demo;
    }

    private static VBox selectableTreeTest() {
        record User(int id, String date, String name, String address, List<User> children) {
        }

        String name = "wangxiaohu";
        String address = "No. 189, Grove St, Los Angeles";

        var rows = FXCollections.observableArrayList(
                new User(1, "2016-05-02", name, address, List.of()),
                new User(2, "2016-05-04", name, address, List.of()),
                new User(3, "2016-05-01", name, address, List.of(
                        new User(31, "2016-05-01", name, address, List.of()),
                        new User(32, "2016-05-01", name, address, List.of()),
                        new User(33, "2016-05-01", name, address, List.of()))),
                new User(4, "2016-05-03", name, address, List.of()));

        var strictly = new EleFXRadioGroup<>(
                new EleFXRadioButton<>("true", true),
                new EleFXRadioButton<>("false", false));
        strictly.setValue(false);

        var table = new EleFXTable<>(rows);
        table.setRowKey(User::id);
        table.setChildrenGetter(User::children);
        table.setDefaultExpandAll(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var selection = new EleFXTableSelectionColumn<User>(User::id);
        selection.setSelectable(user -> user.id() != 1 && user.id() != 31);
        selection.checkStrictlyProperty().bind(strictly.valueProperty());

        var dateColumn = new EleFXTableColumn<User, String>("Date");
        dateColumn.setValueGetter(User::date);

        var nameColumn = new EleFXTableColumn<User, String>("Name");
        nameColumn.setValueGetter(User::name);

        var addressColumn = new EleFXTableColumn<User, String>("Address");
        addressColumn.setValueGetter(User::address);

        table.getColumns().setAll(List.of(selection, dateColumn, nameColumn, addressColumn));

        return new VBox(8, strictly, table);
    }

    private static VBox summaryRowTest() {
        record Product(
                String id, String name, String amount1, String amount2, int amount3) {
        }

        var rows = FXCollections.observableArrayList(
                new Product("12987122", "Tom", "234", "3.2", 10),
                new Product("12987123", "Tom", "165", "4.43", 12),
                new Product("12987124", "Tom", "324", "1.9", 9),
                new Product("12987125", "Tom", "621", "2.2", 17),
                new Product("12987126", "Tom", "539", "4.1", 15));

        var demo = new VBox(20);

        for (boolean custom : List.of(false, true)) {
            var id = new EleFXTableColumn<Product, String>("ID");
            id.setValueGetter(Product::id);
            id.setMinWidth(180);
            id.setMaxWidth(180);
            id.setPrefWidth(180);

            var name = new EleFXTableColumn<Product, String>("Name");
            name.setValueGetter(Product::name);

            var amount1 = new EleFXTableColumn<Product, BigDecimal>(
                    custom ? "Cost 1 ($)" : "Amount 1");
            amount1.setValueGetter(row -> new BigDecimal(row.amount1()));

            var amount2 = new EleFXTableColumn<Product, BigDecimal>(
                    custom ? "Cost 2 ($)" : "Amount 2");
            amount2.setValueGetter(row -> new BigDecimal(row.amount2()));

            var amount3 = new EleFXTableColumn<Product, BigDecimal>(
                    custom ? "Cost 3 ($)" : "Amount 3");
            amount3.setValueGetter(row -> BigDecimal.valueOf(row.amount3()));

            List.of(amount1, amount2, amount3)
                    .forEach(column -> column.setSortable(!custom));

            // 两张表共享数据，各自维护排序顺序。
            var table = new EleFXTable<Product>();
            table.setFilterItems(rows);
            table.setBordered(true);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.getColumns().setAll(List.of(id, name, amount1, amount2, amount3));
            table.setShowSummary(true);

            if (custom) {
                table.setPrefHeight(200);
                table.setSummaryMethod(summary -> summary.columns().stream()
                        .map(column -> {
                            if (column == id) {
                                var title = new Label("Total Cost");
                                title.setUnderline(true);
                                return title;
                            }

                            return summary.data().stream()
                                    .map(column::getCellData)
                                    .filter(BigDecimal.class::isInstance)
                                    .map(BigDecimal.class::cast)
                                    .reduce(BigDecimal::add)
                                    .map(sum -> "$ " + sum.stripTrailingZeros().toPlainString())
                                    .orElse("N/A");
                        })
                        .toList());
            }

            demo.getChildren().add(table);
        }

        return demo;
    }

    private static VBox rowspanAndColspanTest() {
        record Product(
                String id, String name, String amount1, String amount2, int amount3) {
        }

        var rows = FXCollections.observableArrayList(
                new Product("12987122", "Tom", "234", "3.2", 10),
                new Product("12987123", "Tom", "165", "4.43", 12),
                new Product("12987124", "Tom", "324", "1.9", 9),
                new Product("12987125", "Tom", "621", "2.2", 17),
                new Product("12987126", "Tom", "539", "4.1", 15));

        var demo = new VBox(20);

        for (boolean vertical : List.of(false, true)) {
            var id = new EleFXTableColumn<Product, String>("ID");
            id.setValueGetter(Product::id);
            id.setPrefWidth(180);

            var name = new EleFXTableColumn<Product, String>("Name");
            name.setValueGetter(Product::name);

            var amount1 = new EleFXTableColumn<Product, BigDecimal>("Amount 1");
            amount1.setValueGetter(row -> new BigDecimal(row.amount1()));

            var amount2 = new EleFXTableColumn<Product, BigDecimal>("Amount 2");
            amount2.setValueGetter(row -> new BigDecimal(row.amount2()));

            var amount3 = new EleFXTableColumn<Product, Integer>("Amount 3");
            amount3.setValueGetter(Product::amount3);

            List.of(amount1, amount2, amount3)
                    .forEach(column -> column.setSortable(!vertical));

            var table = new EleFXTable<Product>();
            // 两张表共享数据，各自维护显示顺序。
            table.setFilterItems(rows);
            table.setBordered(true);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.getColumns().setAll(List.of(id, name, amount1, amount2, amount3));

            var span = vertical
                    ? new EleFXTable.CellSpan(2, 1)
                    : new EleFXTable.CellSpan(1, 2);

            table.setSpanMethod(cell -> cell.columnIndex() == 0 && cell.rowIndex() % 2 == 0
                    ? span
                    : null);

            demo.getChildren().add(table);
        }

        return demo;
    }

    private static EleFXTable<?> customIndexTest() {
        record User(String date, String name, String address) {
        }

        String address = "No. 189, Grove St, Los Angeles";
        var rows = FXCollections.observableArrayList(
                new User("2016-05-03", "Tom", address),
                new User("2016-05-02", "Tom", address),
                new User("2016-05-04", "Tom", address),
                new User("2016-05-01", "Tom", address));

        var index = new EleFXTableIndexColumn<User>();
        index.setIndexMethod(i -> i * 2);

        var date = new EleFXTableColumn<User, String>("Date");
        date.setValueGetter(User::date);

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);

        for (var column : List.of(date, name)) {
            column.setMinWidth(180);
            column.setPrefWidth(180);
            column.setMaxWidth(180);
        }

        var addressColumn = new EleFXTableColumn<User, String>("Address");
        addressColumn.setValueGetter(User::address);

        var table = new EleFXTable<>(rows);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().setAll(List.of(index, date, name, addressColumn));

        return table;
    }

    private static VBox tableLayoutTest() {
        record User(String date, String name, String address) {
        }

        String street = "No. 189, Grove St, Los Angeles";
        var rows = FXCollections.observableArrayList(
                new User("2016-05-03", "Tom", street),
                new User("2016-05-02", "Tom", street),
                new User("2016-05-04", "Tom", street),
                new User("2016-05-01", "Tom", street));

        var layout = new EleFXRadioGroup<>(
                new EleFXRadioButton<>("fixed", EleFXTableLayout.FIXED),
                new EleFXRadioButton<>("auto", EleFXTableLayout.AUTO));
        layout.setValue(EleFXTableLayout.FIXED);

        var date = new EleFXTableColumn<User, String>("Date");
        date.setValueGetter(User::date);

        var name = new EleFXTableColumn<User, String>("Name");
        name.setValueGetter(User::name);

        var address = new EleFXTableColumn<User, String>("Address");
        address.setValueGetter(User::address);

        var table = new EleFXTable<>(rows);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().setAll(List.of(date, name, address));
        table.tableLayoutProperty().bind(layout.valueProperty());

        return new VBox(8, layout, table);
    }

    private static EleFXTable tooltipFormatterTest() {
        record Row(String address, List<String> tags, String url) {
        }

        String github = "https://github.com/element-plus/element-plus/";

        var table = new EleFXTable<>(FXCollections.observableArrayList(
                new Row(
                        "Lohrbergstr. 86c, Süd Lilli, Saarland",
                        List.of("Office", "Home", "Park", "Garden"),
                        github + "issues"),
                new Row(
                        "760 A Street, South Frankfield, Illinois",
                        List.of("error", "warning", "success", "info"),
                        github + "pulls"),
                new Row(
                        "Arnold-Ohletz-Str. 41a, Alt Malinascheid, Thüringen",
                        List.of("one", "two", "three", "four", "five"),
                        github + "discussions"),
                new Row(
                        "23618 Windsor Drive, West Ricardoview, Idaho",
                        List.of("blue", "white", "dark", "gray", "red", "bright"),
                        github + "actions")));

        table.setTableLayout(EleFXTableLayout.AUTO);
        table.setShowOverflowTooltip(true);
        table.setTooltipFormatter(cell -> cell.cellValue() + ": table formatter");

        // 地址列继承表级 formatter。
        var address = new EleFXTableColumn<Row, String>("继承表级 formatter");
        address.setPrefWidth(220);
        address.setValueGetter(Row::address);

        // 单元格里显示标签，溢出时显示逗号分隔的文本。
        var tags = new EleFXTableColumn<Row, List<String>>("格式化标签");
        tags.setPrefWidth(240);
        tags.setValueGetter(Row::tags);
        tags.setCellGraphicFactory(row -> {
            var box = new HBox(5);
            box.setAlignment(Pos.CENTER_LEFT);
            for (String tag : row.tags()) {
                box.getChildren().add(new EleFXTag(tag, EleFXTagType.PRIMARY));
            }
            return box;
        });
        tags.setTooltipFormatter(cell -> String.join(", ", cell.cellValue()));

        // 单元格里显示 URL，溢出时显示可点击的链接。
        var url = new EleFXTableColumn<Row, String>("链接节点");
        url.setPrefWidth(240);
        url.setValueGetter(Row::url);
        url.setTooltipFormatter(cell -> {
            String href = cell.cellValue();
            var link = new EleFXLink(href, EleFXLinkType.PRIMARY);
            link.setHref(href);
            link.setOnAction(event -> System.out.println(href));
            return link;
        });

        table.getColumns().addAll(List.of(address, tags, url));

        return table;
    }

    private EleFXTableFiller() {
    }
}
