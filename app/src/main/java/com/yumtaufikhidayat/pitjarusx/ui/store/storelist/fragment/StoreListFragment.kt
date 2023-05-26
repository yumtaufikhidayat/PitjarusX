package com.yumtaufikhidayat.pitjarusx.ui.store.storelist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yumtaufikhidayat.pitjarusx.R
import com.yumtaufikhidayat.pitjarusx.databinding.FragmentStoreListBinding
import com.yumtaufikhidayat.pitjarusx.model.login.Store
import com.yumtaufikhidayat.pitjarusx.ui.store.storelist.viewmodel.StoreListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StoreListFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentStoreListBinding? = null
    private val binding get() = _binding!!

    private var mMap: GoogleMap? = null
    private val viewModel: StoreListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStoreListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleBackNavigation()
        setMap()
    }

    private fun handleBackNavigation() {
        binding.imgBackArrow.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        setObserver()
    }

    private fun setObserver() {
        viewModel.getLogin().observe(viewLifecycleOwner) {
            setMarkers(it)
        }
    }

    private fun setMarkers(store: List<Store>) {
        binding.apply {
            val username = store[0].accountName
            tvToolbarSubtitle.text = username
            store.forEach {
                val latitude = it.latitude.toDouble()
                val longitude = it.longitude.toDouble()
                val latLng = LatLng(latitude, longitude)

                mMap?.let { gMap ->
                    gMap.addMarker(
                        MarkerOptions()
                            .position(latLng)
                            .title(it.storeName)
                    )
                    gMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            latLng,
                            ZOOM_LEVEL
                        )
                    )
                }
            }
        }
    }

    companion object {
        private const val ZOOM_LEVEL = 15f
    }
}