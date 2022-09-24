package me.taste2plate.app.customer;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.taste2plate.app.customer.databinding.ActivityAllOffersBindingImpl;
import me.taste2plate.app.customer.databinding.ActivityMembershipListBindingImpl;
import me.taste2plate.app.customer.databinding.ActivityMyPlanBindingImpl;
import me.taste2plate.app.customer.databinding.ActivityNewAddressBindingImpl;
import me.taste2plate.app.customer.databinding.ActivityOffersBindingImpl;
import me.taste2plate.app.customer.databinding.ActivityOrderConfirmedBindingImpl;
import me.taste2plate.app.customer.databinding.ActivityWalletBindingImpl;
import me.taste2plate.app.customer.databinding.CaraouselLayoutBindingImpl;
import me.taste2plate.app.customer.databinding.CategoryContainerBindingImpl;
import me.taste2plate.app.customer.databinding.CheckoutFlowLayoutBindingImpl;
import me.taste2plate.app.customer.databinding.ItemGeneralChoiceBindingImpl;
import me.taste2plate.app.customer.databinding.ItemIntermediateBindingImpl;
import me.taste2plate.app.customer.databinding.ListAlertDialogBindingImpl;
import me.taste2plate.app.customer.databinding.LocationPickerBindingImpl;
import me.taste2plate.app.customer.databinding.LocationSelectionFragmentBindingImpl;
import me.taste2plate.app.customer.databinding.PlanItemBindingImpl;
import me.taste2plate.app.customer.databinding.ProductsContainerBindingImpl;
import me.taste2plate.app.customer.databinding.RewardActivityBindingImpl;
import me.taste2plate.app.customer.databinding.SingleHomeCategoryItemBindingImpl;
import me.taste2plate.app.customer.databinding.SingleHomeProductItemBindingImpl;
import me.taste2plate.app.customer.databinding.SingleSliderImageBindingImpl;
import me.taste2plate.app.customer.databinding.TitleItemBindingImpl;
import me.taste2plate.app.customer.databinding.ToolbarBindingImpl;
import me.taste2plate.app.customer.databinding.TransactionItemBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYALLOFFERS = 1;

  private static final int LAYOUT_ACTIVITYMEMBERSHIPLIST = 2;

  private static final int LAYOUT_ACTIVITYMYPLAN = 3;

  private static final int LAYOUT_ACTIVITYNEWADDRESS = 4;

  private static final int LAYOUT_ACTIVITYOFFERS = 5;

  private static final int LAYOUT_ACTIVITYORDERCONFIRMED = 6;

  private static final int LAYOUT_ACTIVITYWALLET = 7;

  private static final int LAYOUT_CARAOUSELLAYOUT = 8;

  private static final int LAYOUT_CATEGORYCONTAINER = 9;

  private static final int LAYOUT_CHECKOUTFLOWLAYOUT = 10;

  private static final int LAYOUT_ITEMGENERALCHOICE = 11;

  private static final int LAYOUT_ITEMINTERMEDIATE = 12;

  private static final int LAYOUT_LISTALERTDIALOG = 13;

  private static final int LAYOUT_LOCATIONPICKER = 14;

  private static final int LAYOUT_LOCATIONSELECTIONFRAGMENT = 15;

  private static final int LAYOUT_PLANITEM = 16;

  private static final int LAYOUT_PRODUCTSCONTAINER = 17;

  private static final int LAYOUT_REWARDACTIVITY = 18;

  private static final int LAYOUT_SINGLEHOMECATEGORYITEM = 19;

  private static final int LAYOUT_SINGLEHOMEPRODUCTITEM = 20;

  private static final int LAYOUT_SINGLESLIDERIMAGE = 21;

  private static final int LAYOUT_TITLEITEM = 22;

  private static final int LAYOUT_TOOLBAR = 23;

  private static final int LAYOUT_TRANSACTIONITEM = 24;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(24);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_all_offers, LAYOUT_ACTIVITYALLOFFERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_membership_list, LAYOUT_ACTIVITYMEMBERSHIPLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_my_plan, LAYOUT_ACTIVITYMYPLAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_new_address, LAYOUT_ACTIVITYNEWADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_offers, LAYOUT_ACTIVITYOFFERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_order_confirmed, LAYOUT_ACTIVITYORDERCONFIRMED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.activity_wallet, LAYOUT_ACTIVITYWALLET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.caraousel_layout, LAYOUT_CARAOUSELLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.category_container, LAYOUT_CATEGORYCONTAINER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.checkout_flow_layout, LAYOUT_CHECKOUTFLOWLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.item_general_choice, LAYOUT_ITEMGENERALCHOICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.item_intermediate, LAYOUT_ITEMINTERMEDIATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.list_alert_dialog, LAYOUT_LISTALERTDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.location_picker, LAYOUT_LOCATIONPICKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.location_selection_fragment, LAYOUT_LOCATIONSELECTIONFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.plan_item, LAYOUT_PLANITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.products_container, LAYOUT_PRODUCTSCONTAINER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.reward_activity, LAYOUT_REWARDACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.single_home_category_item, LAYOUT_SINGLEHOMECATEGORYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.single_home_product_item, LAYOUT_SINGLEHOMEPRODUCTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.single_slider_image, LAYOUT_SINGLESLIDERIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.title_item, LAYOUT_TITLEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.toolbar, LAYOUT_TOOLBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.taste2plate.app.customer.R.layout.transaction_item, LAYOUT_TRANSACTIONITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYALLOFFERS: {
          if ("layout/activity_all_offers_0".equals(tag)) {
            return new ActivityAllOffersBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_all_offers is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMEMBERSHIPLIST: {
          if ("layout/activity_membership_list_0".equals(tag)) {
            return new ActivityMembershipListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_membership_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMYPLAN: {
          if ("layout/activity_my_plan_0".equals(tag)) {
            return new ActivityMyPlanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_my_plan is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNEWADDRESS: {
          if ("layout/activity_new_address_0".equals(tag)) {
            return new ActivityNewAddressBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_new_address is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYOFFERS: {
          if ("layout/activity_offers_0".equals(tag)) {
            return new ActivityOffersBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_offers is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDERCONFIRMED: {
          if ("layout/activity_order_confirmed_0".equals(tag)) {
            return new ActivityOrderConfirmedBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_order_confirmed is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWALLET: {
          if ("layout/activity_wallet_0".equals(tag)) {
            return new ActivityWalletBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wallet is invalid. Received: " + tag);
        }
        case  LAYOUT_CARAOUSELLAYOUT: {
          if ("layout/caraousel_layout_0".equals(tag)) {
            return new CaraouselLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for caraousel_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_CATEGORYCONTAINER: {
          if ("layout/category_container_0".equals(tag)) {
            return new CategoryContainerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_container is invalid. Received: " + tag);
        }
        case  LAYOUT_CHECKOUTFLOWLAYOUT: {
          if ("layout/checkout_flow_layout_0".equals(tag)) {
            return new CheckoutFlowLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for checkout_flow_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMGENERALCHOICE: {
          if ("layout/item_general_choice_0".equals(tag)) {
            return new ItemGeneralChoiceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_general_choice is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINTERMEDIATE: {
          if ("layout/item_intermediate_0".equals(tag)) {
            return new ItemIntermediateBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_intermediate is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTALERTDIALOG: {
          if ("layout/list_alert_dialog_0".equals(tag)) {
            return new ListAlertDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_alert_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_LOCATIONPICKER: {
          if ("layout/location_picker_0".equals(tag)) {
            return new LocationPickerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for location_picker is invalid. Received: " + tag);
        }
        case  LAYOUT_LOCATIONSELECTIONFRAGMENT: {
          if ("layout/location_selection_fragment_0".equals(tag)) {
            return new LocationSelectionFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for location_selection_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_PLANITEM: {
          if ("layout/plan_item_0".equals(tag)) {
            return new PlanItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for plan_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PRODUCTSCONTAINER: {
          if ("layout/products_container_0".equals(tag)) {
            return new ProductsContainerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for products_container is invalid. Received: " + tag);
        }
        case  LAYOUT_REWARDACTIVITY: {
          if ("layout/reward_activity_0".equals(tag)) {
            return new RewardActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for reward_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLEHOMECATEGORYITEM: {
          if ("layout/single_home_category_item_0".equals(tag)) {
            return new SingleHomeCategoryItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_home_category_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLEHOMEPRODUCTITEM: {
          if ("layout/single_home_product_item_0".equals(tag)) {
            return new SingleHomeProductItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_home_product_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLESLIDERIMAGE: {
          if ("layout/single_slider_image_0".equals(tag)) {
            return new SingleSliderImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_slider_image is invalid. Received: " + tag);
        }
        case  LAYOUT_TITLEITEM: {
          if ("layout/title_item_0".equals(tag)) {
            return new TitleItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for title_item is invalid. Received: " + tag);
        }
        case  LAYOUT_TOOLBAR: {
          if ("layout/toolbar_0".equals(tag)) {
            return new ToolbarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for toolbar is invalid. Received: " + tag);
        }
        case  LAYOUT_TRANSACTIONITEM: {
          if ("layout/transaction_item_0".equals(tag)) {
            return new TransactionItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for transaction_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "choice");
      sKeys.put(2, "planModel");
      sKeys.put(3, "sectionTitle");
      sKeys.put(4, "title");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(24);

    static {
      sKeys.put("layout/activity_all_offers_0", me.taste2plate.app.customer.R.layout.activity_all_offers);
      sKeys.put("layout/activity_membership_list_0", me.taste2plate.app.customer.R.layout.activity_membership_list);
      sKeys.put("layout/activity_my_plan_0", me.taste2plate.app.customer.R.layout.activity_my_plan);
      sKeys.put("layout/activity_new_address_0", me.taste2plate.app.customer.R.layout.activity_new_address);
      sKeys.put("layout/activity_offers_0", me.taste2plate.app.customer.R.layout.activity_offers);
      sKeys.put("layout/activity_order_confirmed_0", me.taste2plate.app.customer.R.layout.activity_order_confirmed);
      sKeys.put("layout/activity_wallet_0", me.taste2plate.app.customer.R.layout.activity_wallet);
      sKeys.put("layout/caraousel_layout_0", me.taste2plate.app.customer.R.layout.caraousel_layout);
      sKeys.put("layout/category_container_0", me.taste2plate.app.customer.R.layout.category_container);
      sKeys.put("layout/checkout_flow_layout_0", me.taste2plate.app.customer.R.layout.checkout_flow_layout);
      sKeys.put("layout/item_general_choice_0", me.taste2plate.app.customer.R.layout.item_general_choice);
      sKeys.put("layout/item_intermediate_0", me.taste2plate.app.customer.R.layout.item_intermediate);
      sKeys.put("layout/list_alert_dialog_0", me.taste2plate.app.customer.R.layout.list_alert_dialog);
      sKeys.put("layout/location_picker_0", me.taste2plate.app.customer.R.layout.location_picker);
      sKeys.put("layout/location_selection_fragment_0", me.taste2plate.app.customer.R.layout.location_selection_fragment);
      sKeys.put("layout/plan_item_0", me.taste2plate.app.customer.R.layout.plan_item);
      sKeys.put("layout/products_container_0", me.taste2plate.app.customer.R.layout.products_container);
      sKeys.put("layout/reward_activity_0", me.taste2plate.app.customer.R.layout.reward_activity);
      sKeys.put("layout/single_home_category_item_0", me.taste2plate.app.customer.R.layout.single_home_category_item);
      sKeys.put("layout/single_home_product_item_0", me.taste2plate.app.customer.R.layout.single_home_product_item);
      sKeys.put("layout/single_slider_image_0", me.taste2plate.app.customer.R.layout.single_slider_image);
      sKeys.put("layout/title_item_0", me.taste2plate.app.customer.R.layout.title_item);
      sKeys.put("layout/toolbar_0", me.taste2plate.app.customer.R.layout.toolbar);
      sKeys.put("layout/transaction_item_0", me.taste2plate.app.customer.R.layout.transaction_item);
    }
  }
}
