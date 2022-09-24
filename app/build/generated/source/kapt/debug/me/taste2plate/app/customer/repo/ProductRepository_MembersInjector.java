// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import me.taste2plate.app.Woocommerce;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProductRepository_MembersInjector implements MembersInjector<ProductRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public ProductRepository_MembersInjector(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  public static MembersInjector<ProductRepository> create(
      Provider<Woocommerce> woocommerceProvider) {
    return new ProductRepository_MembersInjector(woocommerceProvider);
  }

  @Override
  public void injectMembers(ProductRepository instance) {
    injectWoocommerce(instance, woocommerceProvider.get());
  }

  @InjectedFieldSignature("me.taste2plate.app.customer.repo.ProductRepository.woocommerce")
  public static void injectWoocommerce(ProductRepository instance, Woocommerce woocommerce) {
    instance.woocommerce = woocommerce;
  }
}
