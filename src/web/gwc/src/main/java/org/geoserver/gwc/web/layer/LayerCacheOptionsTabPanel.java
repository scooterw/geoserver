/* Copyright (c) 2012 TOPP - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.gwc.web.layer;

import org.apache.wicket.model.IModel;
import org.geoserver.catalog.LayerInfo;
import org.geoserver.gwc.layer.GeoServerTileLayerInfo;
import org.geoserver.web.data.resource.LayerEditTabPanel;
import org.geoserver.web.data.resource.LayerEditTabPanelInfo;

/**
 * A contribution to the layer edit page to set up the layer caching options on a separate tab.
 * 
 * @author groldan
 * @see GeoServerTileLayerEditor
 * @see LayerEditTabPanelInfo
 * @see LayerGroupCacheOptionsPanel
 */
public class LayerCacheOptionsTabPanel extends LayerEditTabPanel {

    private static final long serialVersionUID = 1L;

    private GeoServerTileLayerEditor editor;

    public LayerCacheOptionsTabPanel(String id, IModel<LayerInfo> layerModel,
            IModel<GeoServerTileLayerInfo> tileLayerModel) {
        super(id, tileLayerModel);

        editor = new GeoServerTileLayerEditor("tileLayerEditor", layerModel, tileLayerModel);
        add(editor);
    }

    @Override
    public void save() {
        editor.save();
    }
}
