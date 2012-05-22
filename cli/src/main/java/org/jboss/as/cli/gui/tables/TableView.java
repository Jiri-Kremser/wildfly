/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.jboss.as.cli.gui.tables;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jboss.as.cli.gui.CliGuiContext;
import org.jboss.as.cli.gui.ManagementModelNode;

/**
 *
 * @author Stan Silvert ssilvert@redhat.com (C) 2012 Red Hat Inc.
 */
public class TableView extends JPanel {

    private String tableName;

    private ReadAttributesTableModel tableModel;
    private JTable table = new JTable();

    public TableView(CliGuiContext cliGuiCtx, String tableName, ManagementModelNode root, List<AttributeType> attrs) throws Exception {
        this.tableName = tableName;
        table.setAutoCreateRowSorter(true);
        setLayout(new BorderLayout());

        JScrollPane scroller = new JScrollPane(table);
        add(scroller, BorderLayout.CENTER);
        this.tableModel = new ReadAttributesTableModel(cliGuiCtx, root, attrs);
        this.table.setModel(tableModel);
    }
}
